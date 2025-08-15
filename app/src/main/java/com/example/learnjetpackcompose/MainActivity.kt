package com.example.learnjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    Column(modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.height(50.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f, fill = true)
                        ) {
                            MainIcon(modifier = Modifier.align(Alignment.Center))
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(2f, fill = true)
                        ) {
                            MainTextField(modifier = Modifier.align(Alignment.Center))
                        }


                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f, fill = true)
                        ) {
                            VersionText()
                        }
                        Spacer(modifier = Modifier.height(50.dp))

                    }

                }
            }
        }
    }
}


@Composable
fun MainIcon(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.logo_icon),
            contentDescription = "A description of the image for accessibility",
            modifier = Modifier.size(70.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row() {
            Text(
                color = Color.Black,
                text = "GX",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                color = Color(0xFFF9C900),
                text = "Sales",
                fontSize = 20.sp,
            )
        }

        Text(
            color = Color.Black,
            text = "Committed to better quality",
            fontSize = 11.sp,
        )
    }

}

@Composable
fun MainTextField(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier.padding(horizontal = 20.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Start),
                text = "Email",
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
            ) {
                Spacer(modifier = Modifier.width(15.dp))

                Image(
                    painter = painterResource(id = R.drawable.ic_email),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(17.dp)
                        .align(Alignment.CenterVertically)
                )

                TextField(
                    modifier = Modifier
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
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("type your email") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )

                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Start),
                text = "Password",
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
            ) {
                Spacer(modifier = Modifier.width(15.dp))

                Image(
                    painter = painterResource(id = R.drawable.ic_password),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(17.dp)
                        .align(Alignment.CenterVertically)
                )

                TextField(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent

                    ),
                    textStyle = TextStyle(fontSize = 13.sp),
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("type your password") },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val icon = if (passwordVisible) R.drawable.ic_hide else R.drawable.ic_show
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                painter = painterResource(id = icon),
                                contentDescription = "Toggle password visibility"
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next
                    )
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                SignInButton(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
fun SignInButton(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .height(40.dp)
            .width(100.dp)
            .background(
                color = Color(0xFFF9C900), RoundedCornerShape(size = 8.dp)
            )
    ) {
        Row(modifier = modifier.align(Alignment.Center)) {
            Text(
                color = Color.Black,
                text = "Sign In",
                fontSize = 13.sp,
            )

            Spacer(modifier = modifier.width(5.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_sign_in),
                contentDescription = "Icon",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(20.dp)
            )
        }

        Button(
            modifier = modifier
                .fillMaxSize(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent
            ),
            onClick = { Toast.makeText(context, "Login...", Toast.LENGTH_SHORT).show() }
        ) {

        }
    }
}

@Composable
fun VersionText(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = modifier.align(Alignment.BottomCenter),
            color = Color(0xFF9A9A9A),
            text = "GlobalXtreme © 2023 - v3.0.0",
            fontSize = 12.sp,
        )
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnJetpackComposeTheme {
//        Greeting("Android")
        MainIcon()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    LearnJetpackComposeTheme {
        MainTextField()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    LearnJetpackComposeTheme {
        SignInButton()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    LearnJetpackComposeTheme {
        VersionText()
    }
}