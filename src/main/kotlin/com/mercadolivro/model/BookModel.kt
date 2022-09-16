package com.mercadolivro.model

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.Errors
import com.mercadolivro.exception.BadRequestException
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "book")
data class BookModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "customer_id") //aponta para a chave primária do customer, assim como no SQL
    var customer: CustomerModel? = null

){
    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value) { // um setter
            if(field == BookStatus.CANCELADO || field == BookStatus.DELETADO) // field valor atual da variável
                throw BadRequestException(Errors.ML102.message.format(field), Errors.ML102.code)

            field = value // value é o novo valor para a variável
        }

    constructor(id: Int? = null,
                name: String,
                price: BigDecimal,
                customer: CustomerModel? = null,
                status: BookStatus?): this(id, name, price, customer){
                    this.status = status
                }
}