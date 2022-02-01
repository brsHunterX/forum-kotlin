package br.com.alura.forum.dtos

import javax.validation.constraints.NotEmpty

class TopicUpdateForm(
  @field:NotEmpty val title: String,
  @field:NotEmpty val message: String,
) {}