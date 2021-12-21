package com.begers.cryptocrazy.viewModel

import androidx.lifecycle.ViewModel
import com.begers.cryptocrazy.model.Crypto
import com.begers.cryptocrazy.repository.CryptoRepository
import com.begers.cryptocrazy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {

    suspend fun getCrypto(id: String) : Resource<Crypto> {
        return repository.getCrypto(id)
    }
}