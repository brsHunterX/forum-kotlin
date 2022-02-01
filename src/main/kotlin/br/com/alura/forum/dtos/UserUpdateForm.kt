package br.com.alura.forum.dtos

import javax.validation.constraints.NotEmpty

class UserUpdateForm(
  @field:NotEmpty val name: String,
  @field:NotEmpty val email: String,
) {}