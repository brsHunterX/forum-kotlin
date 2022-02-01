package br.com.alura.forum.services

import br.com.alura.forum.dtos.CourseCreateForm
import br.com.alura.forum.dtos.CourseUpdateForm
import br.com.alura.forum.interfaces.IService
import br.com.alura.forum.mappers.CourseFormMapper
import br.com.alura.forum.models.Course
import br.com.alura.forum.repositories.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
  private val mapper: CourseFormMapper,
  private val repository: CourseRepository,
): IService<Course> {

  override fun list(): List<Course> {
    return repository.findAll();
  }

  override fun find(id: Long): Course {
    return repository.getById(id);
  }

  override fun createOrUpdate(model: Course): Course {
    return repository.save(model);
  }

  override fun delete(id: Long) {
    return repository.deleteById(id);
  }

  fun create(form: CourseCreateForm): Course {
    return createOrUpdate(mapper.fromMap(form));
  }

  fun update(id: Long, form: CourseUpdateForm): Course {
    val user: Course = find(id);

    user.name = form.name;
    user.category = form.category;

    return createOrUpdate(user);
  }
}