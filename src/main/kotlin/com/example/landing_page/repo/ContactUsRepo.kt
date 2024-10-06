package com.example.landing_page.repo

import com.example.landing_page.models.ContactUs
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactUsRepo : JpaRepository<ContactUs,Long> {
}