package br.com.alura.forum.mappers

import br.com.alura.forum.dtos.UserView
import br.com.alura.forum.interfaces.IMapper
import br.com.alura.forum.models.User
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class UserViewMapper: IMapper<User, UserView> {
  override fun fromMap(t: User): UserView {
    return UserView(
      id = t.id,
      name = t.name,
      email = t.email,
    );
  }

  override fun fromList(t: List<User>): List<UserView> {
    return t.stream().map { fromMap(it) }.collect(Collectors.toList());
  }

  override fun fromPage(t: Page<User>): Page<UserView> {
    return t.map { fromMap(it) };
  }
}