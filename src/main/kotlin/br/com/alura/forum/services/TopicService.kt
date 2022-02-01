package br.com.alura.forum.services

import br.com.alura.forum.dtos.TopicCreateForm
import br.com.alura.forum.dtos.TopicUpdateForm
import br.com.alura.forum.mappers.TopicFormMapper
import br.com.alura.forum.models.Topic
import br.com.alura.forum.repositories.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicService(
  private val mapper: TopicFormMapper,
  private val repository: TopicRepository,
) {
  fun list(name: String?, pageable: Pageable): Page<Topic> {
    if (name != null) {
      return repository.findByCourseName(name, pageable);
    }

    return repository.findAll(pageable);
  }

  fun find(id: Long): Topic {
    return repository.getById(id);
  }

  fun createOrUpdate(model: Topic): Topic {
    return repository.save(model);
  }

  fun delete(id: Long) {
    return repository.deleteById(id);
  }

  fun create(form: TopicCreateForm): Topic {
    return createOrUpdate(mapper.fromMap(form));
  }

  fun update(id: Long, form: TopicUpdateForm): Topic {
    val topic: Topic = find(id);

    topic.title = form.title;
    topic.message = form.message;

    return createOrUpdate(topic);
  }
}