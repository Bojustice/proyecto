package com.example.proyecto.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="estudiantes")
class Estudiantes {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(updatable=false)
    var id:Long?=null
    var rolesId:Long?=null
    var nombres:String?=null
    var apellidos:String?=null
    var edad:Int?=null
}