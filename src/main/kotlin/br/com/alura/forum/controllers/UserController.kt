package br.com.alura.forum.controllers

import br.com.alura.forum.dtos.UserCreateForm
import br.com.alura.forum.dtos.UserUpdateForm
import br.com.alura.forum.dtos.UserView
import br.com.alura.forum.mappers.UserViewMapper
import br.com.alura.forum.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(
  private val service: UserService,
  private val mapper: UserViewMapper,
) {

  @GetMapping
  fun index(): ResponseEntity<List<UserView>> {
    val views: List<UserView> = mapper.fromList(service.list());

    return ResponseEntity.ok(views);
  }

  @GetMapping("/{id}")
  fun show(@PathVariable id: Long): ResponseEntity<UserView> {
    val view: UserView = mapper.fromMap(service.find(id));

    return ResponseEntity.ok(view);
  }

  @PostMapping
  @Transactional
  fun create(@RequestBody @Valid form: UserCreateForm, uriBuilder: UriComponentsBuilder): ResponseEntity<UserView> {
    val view: UserView = mapper.fromMap(service.create(form))
    val uri = uriBuilder.path("/courses/${view.id}").build().toUri();

    return ResponseEntity.created(uri).body(view);
  }

  @PutMapping("/{id}")
  @Transactional
  fun update(@PathVariable id: Long, @RequestBody @Valid form: UserUpdateForm): ResponseEntity<UserView> {
    val view: UserView = mapper.fromMap(service.update(id, form));

    return ResponseEntity.ok(view);
  }

  @DeleteMapping("/{id}")
  @Transactional
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun delete(@PathVariable id: Long) {
    return service.delete(id);
  }
}