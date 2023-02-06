package com.example.proyecto.controller
import com.example.proyecto.model.Roles
import com.example.proyecto.service.RolesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Pageable

@RestController
@RequestMapping("/roles")
class RolesController {
    @Autowired
    lateinit var rolesService: RolesService

    @GetMapping
    fun list (roles:Roles, pageable: Pageable):ResponseEntity<*>{
        val response=rolesService.list(pageable,roles)
        return ResponseEntity(rolesService.save(roles), HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody roles:Roles):ResponseEntity<Roles>{
        return ResponseEntity(rolesService.save(roles), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody roles: Roles):ResponseEntity<Roles>{
        return ResponseEntity(rolesService.update(roles), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody roles:Roles):ResponseEntity<Roles>{
        return ResponseEntity(rolesService.updateName(roles), HttpStatus.OK)
    }

}