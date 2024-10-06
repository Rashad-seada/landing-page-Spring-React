package com.example.landing_page.service

import com.example.landing_page.dto.SubmitContactDto
import com.example.landing_page.models.ContactUs
import com.example.landing_page.repo.ContactUsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContactUsService @Autowired constructor(
    val contactUsRepo: ContactUsRepo
) {

    fun submitContact(submitContactDto: SubmitContactDto) : ContactUs {
        val contact = ContactUs(
            email = submitContactDto.email,
            phoneNumber = submitContactDto.phoneNumber,
            message = submitContactDto.message
        )

        return contactUsRepo.save(contact)

    }

    fun getAllContacts() : List<ContactUs> {
        return contactUsRepo.findAll()
    }


}