package com.mercadolivro.model

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.enums.Profiles
import javax.persistence.*

@Entity(name = "customer")
data class CustomerModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null, //agora receberá valores nulos e poderá ser utilizado no construtor de outras classes de serviço

    @Column
    var name: String,

    @Column
    var email: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus = CustomerStatus.ATIVO,

    @Column
    val password: String,

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Profiles::class, fetch = FetchType.EAGER)
    @CollectionTable(
        name = "customer_roles",
        joinColumns = [JoinColumn(name = "customer_id")])
    var roles: Set<Profiles> = setOf()
)