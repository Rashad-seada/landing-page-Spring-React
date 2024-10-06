package com.example.landing_page.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull


data class SubmitContactDto (

    @field:Email(message = "must be a valid email")
    @field:NotBlank(message = "email is required")
    val email : String? = null,

    @field:NotBlank(message = "phoneNumber is required")
    val phoneNumber : String? = null,

    @field:NotBlank(message = "message is required")
    val message : String? = null,
)