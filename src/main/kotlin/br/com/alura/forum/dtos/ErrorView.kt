package br.com.alura.forum.dtos

import java.time.LocalDateTime

class ErrorView(
  val timestamp: LocalDateTime = LocalDateTime.now(),
  val status: Int,
  val error: String,
  val message: String?,
  val path: String,
) {}