package br.com.alura.forum.models

import javax.persistence.*

@Entity
@Table(name="course")
data class Course (

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val id: Long? = null,

  @Column(name = "name", nullable = false)
  var name: String,

  @Column(name = "category", nullable = false)
  var category: String,
) {}
