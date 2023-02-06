package com.example.proyecto.repository
import com.example.proyecto.model.Roles
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RolesRepository: JpaRepository<Roles,Long> {
    fun findById(id:Long?):Roles?
}