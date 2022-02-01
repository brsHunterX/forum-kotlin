package br.com.alura.forum.exceptions

class NotFoundException(message: String? = "Registro não encontrado"): RuntimeException(message) {
}