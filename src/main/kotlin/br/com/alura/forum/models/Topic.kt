package br.com.alura.forum.models

import java.time.LocalDateTime
import br.com.alura.forum.enums.TopicStatus
import javax.persistence.*

@Entity
@Table(name="topics")
data class Topic(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val id: Long? = null,

  @Column(name = "title", nullable = false)
  var title: String,

  @Column(name = "message", nullable = false)
  var message: String,

  @Column(name = "created_at", nullable = false)
  val createdAt: LocalDateTime = LocalDateTime.now(),

  @Enumerated(value = EnumType.STRING)
  @Column(name = "status", nullable = false)
  val status: TopicStatus = TopicStatus.NOT_ANSWERED,

  @ManyToOne
  @JoinColumn(name="author_id")
  val author: User,

  @ManyToOne
  @JoinColumn(name="course_id")
  val course: Course,

  @OneToMany(mappedBy = "topic")
  val answers: List<Answer> = listOf(),
) { }