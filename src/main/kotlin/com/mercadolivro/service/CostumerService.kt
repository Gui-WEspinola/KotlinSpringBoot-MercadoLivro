package com.mercadolivro.service

import com.mercadolivro.controller.request.PostCostumerRequest
import com.mercadolivro.controller.request.PutCostumerRequest
import com.mercadolivro.model.CostumerModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
class CostumerService {

    val costumers = mutableListOf<CostumerModel>()

    fun getAll(name: String?): List<CostumerModel> { //o ponto de interrogação indica que a variável pode ser nula
        name?.let{// essa linha de código só será executada caso a string name não seja nula na URL
            return costumers.filter { it.name.contains(name, true) }
        } // a url de request ficaria assim: http://localhost:8080/costumer/?nome=guilherme
        return costumers
    }

    fun getById(id: String): CostumerModel {
        return costumers.filter { it.id == id }.first()
    }

    fun create(costumer: PostCostumerRequest) {
        val id = if (costumers.isEmpty()){
            1
        }else {
            costumers.last().id.toInt() + 1
        }.toString()
        costumers.add(CostumerModel(id, costumer.name, costumer.email))
    }

    fun update( id: String, costumer: PutCostumerRequest) {
        costumers.filter { it.id == id }.first().let {
            it.name = costumer.name
            it.email = costumer.email
        }
    }

    fun delete(id: String) {
        costumers.removeIf { it.id == id }
    }


}