package br.com.alura.forum.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="answer")
data class Answer(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val id: Long? = null,

  @Column(name = "message", nullable = false)
  val message: String,

  @Column(name = "created_at", nullable = false)
  val createdAt: LocalDateTime = LocalDateTime.now(),

  @Column(name = "is_soluction", nullable = false)
  val isSoluction: Boolean,

  @ManyToOne
  @JoinColumn(name="author_id")
  val author: User,

  @ManyToOne
  @JoinColumn(name="topic_id")
  val topic: Topic,
) { }
