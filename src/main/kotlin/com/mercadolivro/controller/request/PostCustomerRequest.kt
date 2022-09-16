package com.mercadolivro.controller.request

import com.mercadolivro.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest (

    //na prática, é um DTO
    @field:NotEmpty(message = "Nome deve ser informado.")
    var name: String,

    @field:Email(message = "E-mail deve ser válido.")
    @EmailAvailable
    var email: String
)