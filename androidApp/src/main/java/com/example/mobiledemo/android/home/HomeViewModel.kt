package com.example.mobiledemo.android.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiledemo.ProductsApi
import com.example.mobiledemo.RequestState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private var _requestState: MutableState<RequestState> = mutableStateOf(RequestState.Idle)
    var requestState: State<RequestState> = _requestState

    init {
        viewModelScope.launch(Dispatchers.Main) {
            ProductsApi().fetchProducts(limit = 10).collectLatest {
                _requestState.value = it
            }
        }
    }
}