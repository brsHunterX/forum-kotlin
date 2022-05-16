package br.com.alura.forum.services

import br.com.alura.forum.dtos.UserCreateForm
import br.com.alura.forum.dtos.UserUpdateForm
import br.com.alura.forum.interfaces.IService
import br.com.alura.forum.mappers.UserFormMapper
import br.com.alura.forum.models.User
import br.com.alura.forum.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class UserService(
  private val mapper: UserFormMapper,
  private val repository: UserRepository
): UserDetailsService {
  fun list(): List<User> {
    return repository.findAll();
  }

  fun find(id: Long): User {
    return repository.getById(id);
  }

  fun createOrUpdate(model: User): User {
    return repository.save(model);
  }

  fun delete(id: Long) {
    return repository.deleteById(id);
  }

  fun create(form: UserCreateForm): User {
    return createOrUpdate(mapper.fromMap(form));
  }

  fun update(id: Long, form: UserUpdateForm): User {
    val user: User = find(id);

    user.name = form.name;
    user.email = form.email;

    return createOrUpdate(user);
  }

  override fun loadUserByUsername(username: String?): UserDetails {
    val user: User = repository.findByEmail(username) ?: throw RuntimeException();

    return UserDetailService(user);
  }
}