package br.com.alura.forum.controllers

import br.com.alura.forum.dtos.TopicCreateForm
import br.com.alura.forum.dtos.TopicUpdateForm
import br.com.alura.forum.dtos.TopicView
import br.com.alura.forum.mappers.TopicViewMapper
import br.com.alura.forum.services.TopicService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(
  private val service: TopicService,
  private val mapper: TopicViewMapper,
) {

  @GetMapping
  fun index(
    @RequestParam(required = false) name: String?,
    @PageableDefault(size = 25, sort = ["createdAt"], direction = Sort.Direction.DESC) pageable: Pageable
  ): ResponseEntity<Page<TopicView>> {
    val views: Page<TopicView> = mapper.fromPage(service.list(name, pageable));

    return ResponseEntity.ok(views);
  }

  @GetMapping("/{id}")
  fun show(@PathVariable id: Long): ResponseEntity<TopicView> {
    val view: TopicView = mapper.fromMap(service.find(id));

    return ResponseEntity.ok(view);
  }

  @PostMapping
  @Transactional
  fun create(@RequestBody @Valid form: TopicCreateForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicView> {
    val view: TopicView = mapper.fromMap(service.create(form))
    val uri = uriBuilder.path("/topics/${view.id}").build().toUri();

    return ResponseEntity.created(uri).body(view);
  }

  @PutMapping("/{id}")
  @Transactional
  fun update(@PathVariable id: Long, @RequestBody @Valid form: TopicUpdateForm): ResponseEntity<TopicView> {
    val view: TopicView = mapper.fromMap(service.update(id, form));

    return ResponseEntity.ok(view);
  }

  @DeleteMapping("/{id}")
  @Transactional
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun delete(@PathVariable id: Long) {
    return service.delete(id);
  }
}