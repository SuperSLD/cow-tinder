package com.example.app_domain.usecases.courses

import com.example.app_domain.datacontracts.net.CoursesNetRepository

class GetCoursesUseCase(
    private val coursesNetRepository: CoursesNetRepository,
) {

    suspend operator fun invoke() =
        coursesNetRepository.get()
}