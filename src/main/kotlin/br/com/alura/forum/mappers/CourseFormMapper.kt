package br.com.alura.forum.mappers

import br.com.alura.forum.dtos.CourseCreateForm
import br.com.alura.forum.dtos.CourseView
import br.com.alura.forum.interfaces.IMapper
import br.com.alura.forum.models.Course
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
class CourseFormMapper(): IMapper<CourseCreateForm, Course> {
  override fun fromMap(t: CourseCreateForm): Course {
    return Course(
      name = t.name,
      category = t.category,
    );
  }

  override fun fromList(t: List<CourseCreateForm>): List<Course> {
    TODO("Not yet implemented")
  }

  override fun fromPage(t: Page<CourseCreateForm>): Page<Course> {
    TODO("Not yet implemented")
  }
}