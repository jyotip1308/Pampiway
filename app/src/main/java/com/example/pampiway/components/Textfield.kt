package com.example.pampiway.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {},
    color: Color = Color.Black,
    iconResId: Int? = null, // Set to null by default for leading icon
    trailingIconResId: Int? = null, // Set to null by default for trailing icon
    maxLength: Int,
    keyboardOptions: KeyboardOptions
) {
    OutlinedTextField(
        value = text,
        onValueChange = { val newText = it.take(maxLength)
            onTextChange(newText)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Gray
        ),
        maxLines = maxLine,
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = label, fontSize = 14.sp, color = Color.Gray) },
        textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
        keyboardOptions = keyboardOptions,
        leadingIcon = if (iconResId != null) {
            {
                Icon(
                    painter = painterResource(id = iconResId),
                    contentDescription = "Leading Icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Unspecified
                )
            }
        } else null,
        trailingIcon = if (trailingIconResId != null) {
            {
                Icon(
                    painter = painterResource(id = trailingIconResId),
                    contentDescription = "Trailing Icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Unspecified
                )
            }
        } else null
    )
}

