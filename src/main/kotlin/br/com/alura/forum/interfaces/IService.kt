package br.com.alura.forum.interfaces

interface IService<Model> {
  fun list(): List<Model>
  fun find(id: Long): Model
  fun createOrUpdate(model: Model): Model
  fun delete(id: Long)
}