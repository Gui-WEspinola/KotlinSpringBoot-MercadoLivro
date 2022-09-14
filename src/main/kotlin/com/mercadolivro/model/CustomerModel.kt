package com.mercadolivro.model

import javax.persistence.*

@Entity(name = "customer")
data class CustomerModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null, //agora receberá valores nulos e poderá ser utilizado no construtor de outras classes de serviço

    @Column
    var name: String,

    @Column
    var email: String
)