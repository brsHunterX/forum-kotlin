package br.com.alura.forum.dtos

import br.com.alura.forum.enums.TopicStatus

data class TopicView(
  val id: Long?,
  val title: String,
  val message: String,
  val status: TopicStatus,
) {}