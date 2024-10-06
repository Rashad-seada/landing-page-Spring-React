package com.example.landing_page.models

import jakarta.persistence.*


@Entity
@Table(name = "contact_us")
data class ContactUs(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long? = null,

    @Column(unique = false, nullable = true)
    val email : String? = null,

    @Column(unique = false, nullable = true)
    val phoneNumber : String? = null,

    @Column(unique = false, nullable = true)
    val message : String? = null,

)