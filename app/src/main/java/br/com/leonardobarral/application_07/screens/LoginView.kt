package br.com.leonardobarral.application_07.screens

import android.util.Patterns
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardobarral.application_07.R
import br.com.leonardobarral.application_07.components.TextFieldComponent
import br.com.leonardobarral.application_07.models.LoginViewModel
import br.com.leonardobarral.application_07.models.emailRegex

@Composable
fun LoginView(loginViewModel: LoginViewModel) {

    val email by loginViewModel.email.observeAsState(initial = "")
    val senha by loginViewModel.senha.observeAsState(initial = "")
    val erroEmail by loginViewModel.isErrorEmail.observeAsState(initial = false)
    val erroPassword by loginViewModel.isErrorPassword.observeAsState(initial = false)


    Column (
        modifier = Modifier
            .padding(20.dp)
    ){
        Text(
            text = stringResource(id = R.string.login),
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            fontStyle = FontStyle.Normal
        )
        Text(
            text = stringResource(id = R.string.subtitle),
            color = Color.DarkGray,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal
        )
        Spacer(modifier = Modifier.height(50.dp))
        Card {
            Column (
                modifier = Modifier
                    .padding(20.dp)
            ){
                TextFieldComponent(
                    labelText = stringResource(id = R.string.email),
                    placeHolderText = stringResource(id = R.string.email_place_holder),
                    valueText = email,
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(BorderStroke(1.dp, color = Color.Gray)),
                    updaterState = {
                        loginViewModel.updateEmail(it)
                    },
                    isErrorValidation = erroEmail,
                    visualTransformationP = VisualTransformation.None
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextFieldComponent(
                    labelText = stringResource(id = R.string.password),
                    placeHolderText = "*********",
                    valueText = senha,
                    keyboardType = KeyboardType.Password,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(BorderStroke(1.dp, color = Color.Gray)),
                    updaterState = {
                        if(it.length <= 8) loginViewModel.updateSenha(it)
                    },
                    isErrorValidation = erroPassword,
                    visualTransformationP = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = {
//                    if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) loginViewModel.updateIsErroEmail(true) else loginViewModel.updateIsErroEmail(false)
                    if(email.isEmpty() || !emailRegex.matches(email)) loginViewModel.updateIsErroEmail(true) else loginViewModel.updateIsErroEmail(false)


                    if(senha.isEmpty()) loginViewModel.updateIsErroPassword(true) else loginViewModel.updateIsErroPassword(false)


                },modifier = Modifier.fillMaxWidth()) {
                    Text(text = stringResource(id = R.string.enter))
                }
            }
        }
    }
}