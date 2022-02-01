package br.com.alura.forum.mappers

import br.com.alura.forum.dtos.UserCreateForm
import br.com.alura.forum.interfaces.IMapper
import br.com.alura.forum.models.User
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
class UserFormMapper(): IMapper<UserCreateForm, User> {
  override fun fromMap(t: UserCreateForm): User {
    return User(
      name = t.name,
      email = t.email,
    );
  }

  override fun fromList(t: List<UserCreateForm>): List<User> {
    TODO("Not yet implemented")
  }

  override fun fromPage(t: Page<UserCreateForm>): Page<User> {
    TODO("Not yet implemented")
  }
}