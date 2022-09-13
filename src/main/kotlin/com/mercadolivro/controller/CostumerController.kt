package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCostumerRequest
import com.mercadolivro.controller.request.PutCostumerRequest
import com.mercadolivro.model.CostumerModel
import com.mercadolivro.service.CostumerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import kotlin.math.cos

@RestController
@RequestMapping("costumer")
class CostumerController(
    val costumerService : CostumerService //forma de fazer injeção de dependência no Kotlin
) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CostumerModel> {
        return costumerService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): CostumerModel {
        return costumerService.getById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody costumer: PostCostumerRequest) {
        costumerService.create(costumer)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody costumer: PutCostumerRequest) {
        costumerService.update(id, costumer)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        costumerService.delete(id)
    }

}