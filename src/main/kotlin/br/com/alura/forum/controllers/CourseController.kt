package br.com.alura.forum.controllers

import br.com.alura.forum.dtos.CourseCreateForm
import br.com.alura.forum.dtos.CourseUpdateForm
import br.com.alura.forum.dtos.CourseView
import br.com.alura.forum.mappers.CourseViewMapper
import br.com.alura.forum.services.CourseService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/courses")
class CourseController(
  private val service: CourseService,
  private val mapper: CourseViewMapper,
) {

  @GetMapping
  @Cacheable("courses")
  fun index(): ResponseEntity<List<CourseView>> {
    val views: List<CourseView> = mapper.fromList(service.list());

    return ResponseEntity.ok(views);
  }

  @GetMapping("/{id}")
  fun show(@PathVariable id: Long): ResponseEntity<CourseView> {
    val view: CourseView = mapper.fromMap(service.find(id));

    return ResponseEntity.ok(view);
  }

  @PostMapping
  @Transactional
  @CacheEvict(value = ["courses"], allEntries = true)
  fun create(@RequestBody @Valid form: CourseCreateForm, uriBuilder: UriComponentsBuilder): ResponseEntity<CourseView> {
    val view: CourseView = mapper.fromMap(service.create(form))
    val uri = uriBuilder.path("/courses/${view.id}").build().toUri();

    return ResponseEntity.created(uri).body(view);
  }

  @PutMapping("/{id}")
  @Transactional
  @CacheEvict(value = ["courses"], allEntries = true)
  fun update(@PathVariable id: Long, @RequestBody @Valid form: CourseUpdateForm): ResponseEntity<CourseView> {
    val view: CourseView = mapper.fromMap(service.update(id, form));

    return ResponseEntity.ok(view);
  }

  @DeleteMapping("/{id}")
  @Transactional
  @CacheEvict(value = ["courses"], allEntries = true)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun delete(@PathVariable id: Long) {
    return service.delete(id);
  }
}