package com.mercadolivro.controller.request

import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

class PostPurchaseRequest (

    @field:NotNull
    @field:PositiveOrZero
    val customerId: Int,

    @field:NotNull
    val bookIds: Set<Int>

)
