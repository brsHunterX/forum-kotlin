package br.com.alura.forum.mappers

import br.com.alura.forum.dtos.TopicCreateForm
import br.com.alura.forum.interfaces.IMapper
import br.com.alura.forum.models.Topic
import br.com.alura.forum.services.CourseService
import br.com.alura.forum.services.UserService
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
  val userService: UserService,
  val courseService: CourseService,
): IMapper<TopicCreateForm, Topic> {
  override fun fromMap(t: TopicCreateForm): Topic {
    return Topic(
      title = t.title,
      message = t.message,
      author = userService.find(t.authorId),
      course = courseService.find(t.courseId),
    );
  }

  override fun fromList(t: List<TopicCreateForm>): List<Topic> {
    TODO("Not yet implemented")
  }

  override fun fromPage(t: Page<TopicCreateForm>): Page<Topic> {
    TODO("Not yet implemented")
  }
}