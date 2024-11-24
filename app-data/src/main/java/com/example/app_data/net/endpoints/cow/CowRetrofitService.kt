package com.example.app_data.net.endpoints.cow

import com.example.app_data.net.endpoints.DataWrapper
import com.example.app_data.net.endpoints.user.LoginRequest
import com.example.app_domain.models.cow.Cow
import com.example.app_domain.models.cow.CowPairData
import com.example.app_domain.models.cow.CowPairResult
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CowRetrofitService {

    @GET("cow/find/{id}")
    suspend fun findCow(@Path("id") id: String) : DataWrapper<Cow>

    @GET("cow/all")
    suspend fun allCows() : DataWrapper<List<Cow>>

    @POST("cow/findpair")
    suspend fun findPair(@Body request: CowPairData): DataWrapper<List<CowPairResult>>
}