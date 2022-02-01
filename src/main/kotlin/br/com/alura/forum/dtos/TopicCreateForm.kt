package br.com.alura.forum.dtos

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class TopicCreateForm(
  @field:NotEmpty val title: String,
  @field:NotEmpty val message: String,
  @field:NotNull val courseId: Long,
  @field:NotNull val authorId: Long,
) {}