package com.mercadolivro.helper

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.model.PurchaseModel
import java.math.BigDecimal
import java.util.*


fun buildCustomer(
    id: Int? = null,
    name: String = "customer name",
    email: String = "${UUID.randomUUID()}@email.com",
    password: String = "password",

) = CustomerModel(
    id = id,
    name = name,
    email = email,
    password = password,
)

fun buildPurchase(
    id: Int? = null,
    customer: CustomerModel = buildCustomer(),
    books: MutableList<BookModel> = mutableListOf(buildBook()),
    nfe: String? = UUID.randomUUID().toString(),
    price: BigDecimal = BigDecimal.TEN
) = PurchaseModel(
    id = id,
    customer = customer,
    books = books,
    nfe = nfe,
    price = price
)

fun buildBook(
    id: Int? = null,
    name: String = "nome livro",
    price: BigDecimal = BigDecimal.TEN,
    customer: CustomerModel = buildCustomer()
) = BookModel(
    id = id,
    name = name,
    price = price,
    customer = customer,
    status = BookStatus.ATIVO
)