package br.com.alura.forum.models

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
@Table(name="roles")
data class Role(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val id: Long? = null,

  @Column(name = "name", nullable = false)
  var name: String,
): GrantedAuthority {

  override fun getAuthority(): String {
    return name;
  }
}
