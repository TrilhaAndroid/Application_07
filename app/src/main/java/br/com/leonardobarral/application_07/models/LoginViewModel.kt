package br.com.leonardobarral.application_07.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    fun updateEmail(novoValor:String){
        _email.value = novoValor
    }

    private val _senha = MutableLiveData<String>()
    val senha: LiveData<String> = _senha

    fun updateSenha(novoValor:String){
        _senha.value = novoValor
    }

    private val _isErrorEmail = MutableLiveData<Boolean>()
    val isErrorEmail: LiveData<Boolean> = _isErrorEmail

    fun updateIsErroEmail(novoValor:Boolean){
        _isErrorEmail.value = novoValor
    }

    private val _isErrorPassword = MutableLiveData<Boolean>()
    val isErrorPassword: LiveData<Boolean> = _isErrorPassword

    fun updateIsErroPassword(novoValor:Boolean){
        _isErrorPassword.value = novoValor
    }

}