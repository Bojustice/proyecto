package com.example.proyecto.controller
import com.example.proyecto.model.Estudiantes
import com.example.proyecto.service.EstudiantesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/estudiantes")
class EstudiantesController {
    @Autowired
    lateinit var estudiantesService: EstudiantesService

    @GetMapping
    fun list (estudiantes: Estudiantes, pageable: Pageable): ResponseEntity<*> {
        val response=estudiantesService.list(pageable,estudiantes)
        return ResponseEntity(estudiantesService.save(estudiantes), HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody estudiantes: Estudiantes): ResponseEntity<Estudiantes> {
        return ResponseEntity(estudiantesService.save(estudiantes), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody estudiantes: Estudiantes): ResponseEntity<Estudiantes> {
        return ResponseEntity(estudiantesService.update(estudiantes), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody estudiantes: Estudiantes): ResponseEntity<Estudiantes> {
        return ResponseEntity(estudiantesService.updateName(estudiantes), HttpStatus.OK)
    }
}