package com.mercadolivro.model

data class CustomerModel (
    var id: String? = null, //agora receberá valores nulos e poderá ser utilizado no construtor de outras classes de serviço

    var name: String,

    var email: String
)