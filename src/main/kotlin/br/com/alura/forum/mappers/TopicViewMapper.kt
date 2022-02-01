package br.com.alura.forum.mappers

import br.com.alura.forum.dtos.TopicView
import br.com.alura.forum.interfaces.IMapper
import br.com.alura.forum.models.Topic
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class TopicViewMapper: IMapper<Topic, TopicView> {
  override fun fromMap(t: Topic): TopicView {
    return TopicView(
      id = t.id,
      title = t.title,
      message = t.message,
      status = t.status,
    );
  }

  override fun fromList(t: List<Topic>): List<TopicView> {
    return t.stream().map { fromMap(it) }.collect(Collectors.toList());
  }

  override fun fromPage(t: Page<Topic>): Page<TopicView> {
    return t.map { fromMap(it) };
  }
}