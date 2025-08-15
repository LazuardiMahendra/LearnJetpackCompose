package com.example.learnjetpackcompose

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme

class FormPersonalInformationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    Column(modifier = Modifier.fillMaxSize()) {

                    }
                }
            }
        }
    }

}

@Composable
fun TitleText(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = 16.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun FormInputTextField(
    modifier: Modifier = Modifier,
    title: String,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    var input by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = title,
            color = Color.Black,
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal
        )

        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(55.dp)
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
        ) {
            TextField(
                modifier = modifier
                    .fillMaxHeight()
                    .weight(1f),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent

                ),
                textStyle = TextStyle(fontSize = 13.sp),
                value = input,
                onValueChange = { input = it },
                placeholder = { Text(hint) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = ImeAction.Next
                )

            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun FormInputTextFieldPreview() {
    LearnJetpackComposeTheme {
        FormInputTextField(
            modifier = Modifier.fillMaxSize(),
            title = "Location Nickname *",
            hint = "",
            keyboardType = KeyboardType.Text
        )
    }
}
