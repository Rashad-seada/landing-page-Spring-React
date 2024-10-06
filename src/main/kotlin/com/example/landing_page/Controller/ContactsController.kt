package com.example.landing_page.Controller

import com.example.landing_page.core.dto.CustomError
import com.example.landing_page.core.dto.CustomResponse
import com.example.landing_page.core.error.ErrorCode
import com.example.landing_page.dto.SubmitContactDto
import com.example.landing_page.models.ContactUs
import com.example.landing_page.service.ContactUsService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/contact")
@RestController
class ContactsController @Autowired constructor(
    val contactUsService: ContactUsService
){

    @PostMapping("/submit")
    fun submitContact(
        @Valid @RequestBody submitContactDto: SubmitContactDto,
        bindingResult: BindingResult
    ) : CustomResponse<ContactUs> {
        val error = validateRequest<ContactUs>(bindingResult)
        if(error != null) return error
        val contact = contactUsService.submitContact(submitContactDto)
        return CustomResponse(
            isSuccessful = true,
            message = "contact info submitted successfully",
            data = contact,
        )
    }
    @GetMapping("/get-all")
    fun getAllContacts() : CustomResponse<List<ContactUs>> {
        val contact = contactUsService.getAllContacts()
        return CustomResponse(
            isSuccessful = true,
            message = "contact info fetched successfully",
            data = contact,
        )
    }

    fun <T> validateRequest(bindingResult: BindingResult) : CustomResponse<T>?{
        if (bindingResult.hasErrors()) {
            val errorMessages = bindingResult.allErrors.map { it.defaultMessage ?: "Invalid field" }
            return CustomResponse(
                isSuccessful = false,
                message = ErrorCode.VALIDATION_ERROR.defaultMessage,
                error = CustomError(
                    errorCode = ErrorCode.VALIDATION_ERROR.code,
                    message = errorMessages.first()
                )
            )
        }
        return null
    }



}