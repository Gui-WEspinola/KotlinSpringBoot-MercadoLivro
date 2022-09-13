package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> { //o ponto de interrogação indica que a variável pode ser nula
        name?.let{// essa linha de código só será executada caso a string name não seja nula na URL
            return customers.filter { it.name.contains(name, true) }
        } // a url de request ficaria assim: http://localhost:8080/costumer/?nome=guilherme
        return customers
    }

    fun getById(id: String): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    fun create(customer: CustomerModel) {
        val id = if (customers.isEmpty()){
            1
        }else {
            customers.last().id!!.toInt() + 1
        }.toString()

        customer.id = id

        customers.add(CustomerModel(id, customer.name, customer.email))
    }

    fun update(customer: CustomerModel) {
        customers.filter { it.id == customer.id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }


}