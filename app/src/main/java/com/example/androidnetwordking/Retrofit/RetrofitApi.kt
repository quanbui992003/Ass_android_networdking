package com.example.androidnetwordking.Retrofit

import com.example.androidnetwordking.Model.productAge
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitApi {

    @GET("/product/api/")
    fun getAllProduct(): Call<productAge>

//    @Multipart
//    @POST("/user/addUser/")
//    fun sendText(
//        @Part("email") email: RequestBody,
//        @Part("userName") username: RequestBody,
//        @Part("password") password: RequestBody
//    ): Call<Void>

    @FormUrlEncoded
    @POST("/account/addAccount/")
    fun sendText(
        @Field("email") email: String,
        @Field("pass") pass: String,
        @Field("name") name: String,
       @Field("phone") phone: String

    ): Call<Void>

    @FormUrlEncoded
    @POST("/account/Login/")
    fun login(
        @Field("email") email: String,
        @Field("pass") pass: String,
    ): Call<Void>


}