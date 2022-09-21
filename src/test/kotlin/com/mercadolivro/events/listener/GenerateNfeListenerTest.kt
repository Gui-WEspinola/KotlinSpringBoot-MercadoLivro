package com.mercadolivro.events.listener

import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class GenerateNfeListenerTest{

    @InjectMockKs
    private lateinit var generateNfeListener: GenerateNfeListener
}