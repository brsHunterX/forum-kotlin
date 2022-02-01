package br.com.alura.forum.models

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name="user")
data class User(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val id: Long? = null,

  @Column(name = "name", nullable = false)
  var name: String,

  @Column(name = "email", nullable = false)
  var email: String,
) {}