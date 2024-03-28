package br.com.leonardobarral.application_07.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun TextFieldComponent(
    labelText:String,
    placeHolderText: String,
    valueText:String,
    keyboardType: KeyboardType,
    modifier: Modifier,
    updaterState: (String) -> Unit,
    isErrorValidation: Boolean,
    visualTransformationP: VisualTransformation
) {
    TextField(
        value = valueText,
        onValueChange = updaterState,
        placeholder = { Text(text = placeHolderText) },
        label = { Text(text = labelText) },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        isError = isErrorValidation,
        visualTransformation = visualTransformationP
    )
}