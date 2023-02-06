package com.example.proyecto.repository
import com.example.proyecto.model.Estudiantes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EstudiantesRepository: JpaRepository <Estudiantes,Long> {
    fun findById(id:Long?): Estudiantes?
}