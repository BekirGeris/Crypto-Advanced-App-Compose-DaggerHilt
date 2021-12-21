package com.begers.cryptocrazy.repository

import com.begers.cryptocrazy.model.Crypto
import com.begers.cryptocrazy.model.CryptoList
import com.begers.cryptocrazy.service.CryptoAPI
import com.begers.cryptocrazy.util.Constants
import com.begers.cryptocrazy.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor(private val api: CryptoAPI) {

    suspend fun getCryptoList() : Resource<CryptoList> {
        val response = try {
            api.getCryptoList(Constants.API_KEY)
        }catch (e: Exception){
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id: String) : Resource<Crypto>{
        val respomse = try {
            api.getCrypto(Constants.API_KEY, id, Constants.CALL_ATTRIBUTES)
        }catch (e: Exception){
            return Resource.Error("Error.")
        }
        return Resource.Success(respomse)
    }
}