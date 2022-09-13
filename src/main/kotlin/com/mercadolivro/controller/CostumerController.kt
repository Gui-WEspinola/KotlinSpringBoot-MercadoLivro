package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCostumerRequest
import com.mercadolivro.controller.request.PutCostumerRequest
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

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //response status padrão para PUT e PATCH
    fun update(@PathVariable id: String, @RequestBody costumer: PutCostumerRequest) {
        costumers.filter { it.id == id }.first().let {
            it.name = costumer.name
            it.email = costumer.email
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //response status padrão para PUT e PATCH
    fun delete(@PathVariable id: String) {
        costumers.removeIf { it.id == id }
    }

}