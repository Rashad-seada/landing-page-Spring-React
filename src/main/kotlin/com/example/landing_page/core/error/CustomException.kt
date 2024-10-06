package com.example.landing_page.core.error

class CustomException(val errorCode: ErrorCode) : RuntimeException(errorCode.defaultMessage) {
    companion object {
        fun create(errorCode: ErrorCode): CustomException {
            return CustomException(errorCode)
        }
    }
}
