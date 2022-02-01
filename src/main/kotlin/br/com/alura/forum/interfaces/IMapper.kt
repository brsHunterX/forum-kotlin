package br.com.alura.forum.interfaces

import org.springframework.data.domain.Page

interface IMapper<T, U> {
  fun fromMap(t: T): U;
  fun fromList(t: List<T>): List<U>
  fun fromPage(t: Page<T>): Page<U>
}