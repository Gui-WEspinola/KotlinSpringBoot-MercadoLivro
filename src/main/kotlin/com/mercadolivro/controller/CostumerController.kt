package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCostumerRequest
import com.mercadolivro.model.CostumerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import kotlin.math.cos

@RestController
@RequestMapping("costumer")
class CostumerController {

    @GetMapping
    fun getCostumer(): CostumerModel {
        return CostumerModel("1","Guilherme", "gwanderleyespinola@gmail.com")
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody costumer: PostCostumerRequest) {
        println(costumer)
    }
}