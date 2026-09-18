package com.example.figmatraining2.screen.auth

import android.R.attr.data
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.figmatraining2.general.Resource
import com.example.figmatraining2.repository.AppRepository
import com.example.figmatraining2.screen.stateAndEventControl.LoginEvent
import com.example.figmatraining2.screen.stateAndEventControl.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val repository: AppRepository
) : ViewModel() {
  private val _uiState= MutableStateFlow<LoginState>(LoginState())
    val uiState: StateFlow<LoginState> get() = _uiState

    fun onLogInEvent(event: LoginEvent){
        when(event){
            is LoginEvent.OnLoginClick->{
                getLoggedIn()
            }
            is LoginEvent.OnPasswordChange->{
                _uiState.update { it.copy(password = event.password) }
            }
            is LoginEvent.OnUserNameChange->{
                _uiState.update { it.copy(name = event.name) }
            }
        }
    }

    private fun getLoggedIn(){
        viewModelScope.launch {
            repository.getLogin(_uiState.value.password,_uiState.value.name).collect {resource->
                when(resource){
                    is Resource.Loading->{
                        _uiState.update { it.copy(
                            loading = true,
                        ) }
                    }
                    is Resource.Success->{
                        _uiState.update { it.copy(
                            loading = false,
                            isLoggedIn = resource.data
                        ) }
                    }
                    is Resource.Error->{
                        _uiState.update { it.copy(
                            loading = false,
                            isLoggedIn =false,
                            error = resource.message
                        ) }
                    }
                }
            }
        }
    }
}