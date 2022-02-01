package br.com.alura.forum.services

import br.com.alura.forum.dtos.UserCreateForm
import br.com.alura.forum.dtos.UserUpdateForm
import br.com.alura.forum.interfaces.IService
import br.com.alura.forum.mappers.UserFormMapper
import br.com.alura.forum.models.User
import br.com.alura.forum.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
  private val mapper: UserFormMapper,
  private val repository: UserRepository
): IService<User> {
  override fun list(): List<User> {
    return repository.findAll();
  }

  override fun find(id: Long): User {
    return repository.getById(id);
  }

  override fun createOrUpdate(model: User): User {
    return repository.save(model);
  }

  override fun delete(id: Long) {
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
}