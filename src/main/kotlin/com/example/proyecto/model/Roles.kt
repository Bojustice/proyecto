package com.example.proyecto.model

import javax.persistence.*

@Entity
@Table(name="roles")
class Roles {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable=false)
    var id:Long? =null
    var nombres:String?=null
    var apellidos:String?=null
    var email:String?=null
    var rol:Int?=null
}