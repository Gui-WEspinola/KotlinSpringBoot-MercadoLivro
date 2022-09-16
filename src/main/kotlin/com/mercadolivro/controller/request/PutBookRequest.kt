package com.mercadolivro.controller.request

import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PutBookRequest (

    @field: NotEmpty(message = "Name must be valid.")
    var name: String?,

    @field: NotNull(message = "Price cannot be null.")
    var price: BigDecimal?

)
