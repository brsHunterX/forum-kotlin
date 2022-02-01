package br.com.alura.forum.repositories

import br.com.alura.forum.models.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long> {}