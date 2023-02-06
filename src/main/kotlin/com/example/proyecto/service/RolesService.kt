package com.example.proyecto.service
import com.example.proyecto.model.Roles
import com.example.proyecto.repository.RolesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException



@Service
class RolesService {
    @Autowired
    lateinit var rolesRepository: RolesRepository

    fun list():List<Roles>{
        return rolesRepository.findAll()
    }

    fun save(roles:Roles):Roles{
        return rolesRepository.save(roles)
    }

    fun update(roles:Roles):Roles{
        try{
            rolesRepository .findById(roles.id)
                ?:throw Exception("El id ${roles.id} en roles no existe")
            return rolesRepository.save(roles)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(roles:Roles):Roles{
        try{
            val response = rolesRepository.findById(roles.id)
                ?:throw Exception("El id no existe")
                response.apply {
                    nombres=roles.nombres
                }
            return rolesRepository.save(response)
            }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun list (pageable: Pageable, roles: Roles): Page<Roles>{
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return rolesRepository.findAll(Example.of(roles,matcher),pageable)
    }
}