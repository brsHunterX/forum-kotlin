package br.com.alura.forum.models

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name="users")
data class User(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val id: Long? = null,

  @Column(name = "name", nullable = false)
  var name: String,

  @Column(name = "email", nullable = false)
  var email: String,

  @Column(name = "password", nullable = false)
  var password: String,

  @JsonIgnore
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "users_roles")
  val roles: List<Role> = listOf(),
) {}