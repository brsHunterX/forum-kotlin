package br.com.alura.forum.dtos

import javax.validation.constraints.NotEmpty

class CourseUpdateForm(
  @field:NotEmpty val name: String,
  @field:NotEmpty val category: String,
) {}