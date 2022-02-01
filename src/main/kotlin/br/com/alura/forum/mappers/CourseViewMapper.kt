package br.com.alura.forum.mappers

import br.com.alura.forum.dtos.CourseView
import br.com.alura.forum.interfaces.IMapper
import br.com.alura.forum.models.Course
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class CourseViewMapper: IMapper<Course, CourseView> {
  override fun fromMap(t: Course): CourseView {
    return CourseView(
      id = t.id,
      name = t.name,
      category = t.category,
    );
  }

  override fun fromList(t: List<Course>): List<CourseView> {
    return t.stream().map { fromMap(it) }.collect(Collectors.toList());
  }

  override fun fromPage(t: Page<Course>): Page<CourseView> {
    return t.map { fromMap(it) };
  }
}