package com.example.proyecto.service
import com.example.proyecto.model.Estudiantes
import com.example.proyecto.repository.EstudiantesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class EstudiantesService {
    @Autowired
    lateinit var estudiantesRepository: EstudiantesRepository

    fun list():List<Estudiantes>{
        return estudiantesRepository.findAll()
    }

    fun save(estudiantes: Estudiantes): Estudiantes {
        return estudiantesRepository.save(estudiantes)
    }

    fun update(estudiantes: Estudiantes): Estudiantes {
        try{
            estudiantesRepository .findById(estudiantes.id)
                ?:throw Exception("El id ${estudiantes.id} en roles no existe")
            return estudiantesRepository.save(estudiantes)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(estudiantes: Estudiantes): Estudiantes {
        try{
            val response = estudiantesRepository.findById(estudiantes.id)
                ?:throw Exception("El id no existe")
            response.apply {
                nombres=estudiantes.nombres
            }
            return estudiantesRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun list (pageable: Pageable, estudiantes: Estudiantes): Page<Estudiantes> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return estudiantesRepository.findAll(Example.of(estudiantes,matcher),pageable)
    }
}