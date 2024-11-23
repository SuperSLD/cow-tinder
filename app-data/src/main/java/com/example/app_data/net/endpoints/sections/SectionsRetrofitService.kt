package com.example.app_data.net.endpoints.sections

import com.example.app_data.net.endpoints.DataWrapper
import com.example.app_domain.models.sections.Section
import retrofit2.http.GET

interface SectionsRetrofitService {

    @GET("sections/get")
    suspend fun get(): DataWrapper<List<Section>>
}
