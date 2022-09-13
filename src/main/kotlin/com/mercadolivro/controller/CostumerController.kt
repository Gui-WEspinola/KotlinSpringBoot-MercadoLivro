package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCostumerRequest
import com.mercadolivro.model.CostumerModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import kotlin.math.cos

@RestController
@RequestMapping("costumer")
class CostumerController {

    val costumers = mutableListOf<CostumerModel>()

    @GetMapping
    fun getAll(): List<CostumerModel> {
        return costumers
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): CostumerModel {
        return costumers.filter { it.id == id }.first()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody costumer: PostCostumerRequest) {
        val id = if (costumers.isEmpty()){
            1
        }else {
            costumers.last().id.toInt() + 1
        }.toString()

        costumers.add(CostumerModel(id, costumer.name, costumer.email))
    }
}