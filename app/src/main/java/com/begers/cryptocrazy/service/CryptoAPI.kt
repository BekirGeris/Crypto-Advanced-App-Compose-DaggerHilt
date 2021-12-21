package com.begers.cryptocrazy.service

import com.begers.cryptocrazy.model.Crypto
import com.begers.cryptocrazy.model.CryptoList
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoAPI {
    //prices?key=eaaf35b443ed77522c3c114d37a6744c889827eb

    @GET("prices")
    suspend fun getCryptoList(@Query("key") key: String): CryptoList

    @GET("currencies")
    suspend fun getCrypto(
        @Query("key") key: String,
        @Query("ids") id: String,
        @Query("attributes") attributes: String
    ) : Crypto

}