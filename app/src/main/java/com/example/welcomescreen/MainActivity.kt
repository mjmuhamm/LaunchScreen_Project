package com.example.welcomescreen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.welcomescreen.ui.theme.WelcomeScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WelcomeScreenTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//                LaunchScreen()
            }
        }
    }
}

@Composable
@Preview
fun HomeScreen() {
    var currentScreen by rememberSaveable() { mutableStateOf(true) }

    if (currentScreen) {
        LaunchScreen(onNavigate = { currentScreen = false })
    } else {
        SecondScreen(onNavigate = { currentScreen = true })
    }
}

@Composable
fun LaunchScreen(onNavigate: () -> Unit) {
    val fonts = FontFamily(Font(R.font.museo_sans_500), Font(R.font.museo_sans_300))
    var showNewComposable by rememberSaveable { mutableStateOf(false) }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black), verticalArrangement = Arrangement.SpaceAround) {
        val image = painterResource(R.drawable.logo_green_flag)
        val check = painterResource(R.drawable.tick)

        Image(image, contentDescription = "logo",  modifier = Modifier
            .fillMaxWidth()
            .padding(45.dp, 55.dp, 45.dp, 0.dp)
            .size(100.dp))

        Column(modifier = Modifier.padding(40.dp, 80.dp, 0.dp,0.dp)) {
            Text("GreenFlag customers can create an account to access", fontSize = 24.sp, fontFamily = fonts, color = Color.White, fontWeight = FontWeight.Medium, modifier = Modifier.padding(0.dp, 0.dp))
            Column(modifier = Modifier.padding(0.dp, 30.dp)) {
                Row() {
                    Image(check, contentDescription = "check", modifier = Modifier.size(27.dp))
                    Text(
                        "Car Health Updates",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(15.dp, 1.dp)
                    )
                }

                Row(modifier = Modifier.padding(0.dp, 15.dp)) {
                    Image(check, contentDescription = "check", modifier = Modifier.size(27.dp))
                    Text(
                        "Request a Rescue Online",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(15.dp, 1.dp)
                    )
                }

                Row() {
                    Image(check, contentDescription = "check", modifier = Modifier.size(27.dp))
                    Text(
                        "Policy Information",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(15.dp, 1.dp)
                    )
                }
            }
        }


        Button(onClick = onNavigate , shape = RectangleShape, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent), modifier = Modifier.padding(0.dp,130.dp,0.dp,0.dp) ) {
            Box() {
                Image(painterResource(R.drawable.gradient_button_background), contentDescription = "gradient")
                Text(
                    text = "Create an Account",
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontFamily = fonts,
                    color = Color.Black,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
                )

            }

        }
    }
}

@Composable

fun SecondScreen(onNavigate: () -> Unit) {
    val fonts = FontFamily(Font(R.font.museo_sans_500), Font(R.font.museo_sans_300))
    var showNewComposable by rememberSaveable { mutableStateOf(false) }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var repeatPassword by rememberSaveable { mutableStateOf("") }

    var isValidEmail by remember { mutableStateOf(true) }
    var isValidPassword by remember { mutableStateOf(true) }
    var isValidRepeatPassword by remember { mutableStateOf(true) }

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(0.dp, 6.dp, 0.dp, 0.dp)
    , verticalArrangement = Arrangement.SpaceEvenly) {

        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier) {
                    Text(
                        "<",
                        color = Color.Green,
                        fontSize = 50.sp,
                        fontFamily = fonts,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(20.dp, 0.dp, 20.dp, 0.dp)
                            .clickable(onClick = onNavigate ))

                }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Conditionally show the new composable

//                    Text(
//                        "<",
//                        color = Color.Green,
//                        fontSize = 50.sp,
//                        fontFamily = fonts,
//                        fontWeight = FontWeight.Light,
//                        modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp).clickable {
//
//                        }
//                    )

                Text(
                    "Create an account",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(10.dp, 14.dp, 0.dp, 0.dp)
                )
            }
            HorizontalDivider(
                modifier = Modifier.padding(top = 15.dp),
                thickness = 0.8.dp,
                color = Color.Gray
            )

            Column(modifier = Modifier.padding(20.dp, 35.dp, 0.dp, 0.dp)) {
                Column {
                    Text(
                        "Email address",
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(0.dp, 0.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        label = { Text("Enter your email address") },
                        value = email,
                        isError = !isValidEmail,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .background(Color.White)
                            .onFocusChanged() { focusState ->
                                if (!focusState.isFocused) {
                                    isValidEmail = isValidEmail(email)

                                    if (!isValidEmail) {
                                        Toast.makeText(
                                            context,
                                            "Invalid email address",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }


                            },
                    )
                }
                Column(modifier = Modifier.padding(top = 30.dp)) {
                    Text(
                        "Password",
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(0.dp, 0.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        label = { Text("Enter your password") },
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier
                            .background(Color.White)
                            .onFocusChanged {
                                if (!it.isFocused) {
                                    isValidPassword = isValidPassword1(password)

                                    if (!isValidEmail) {
                                        Toast.makeText(
                                            context,
                                            "Invalid password",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }

                            }
                    )
                }
                Column(modifier = Modifier.padding(top = 30.dp)) {
                    Text(
                        "Repeat Password",
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(0.dp, 0.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        label = { Text("Confirm your password") },
                        value = repeatPassword,
                        onValueChange = { repeatPassword = it },
                        modifier = Modifier
                            .background(Color.White)
                            .onFocusChanged {
                                if (!it.isFocused) {
                                    if (repeatPassword != password) {
                                        Toast.makeText(
                                            context,
                                            "Passwords do not match",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            }
                    )
                }

                Text("Your password should have a minimum of 8 characters and contain at least one number, one uppercase and one lower case letter. You can use special characters", fontSize = 20.sp, color = Color.White, modifier = Modifier.padding(top = 55.dp, end = 20.dp))


            }

            Button(onClick = {  }, shape = RectangleShape, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent), modifier = Modifier.padding(0.dp,100.dp,0.dp,0.dp) ) {
                Box() {
                    Image(painterResource(R.drawable.gradient_button_background), contentDescription = "gradient")
                    Text(
                        text = "Next",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = fonts,
                        color = Color.Black,
                        fontWeight = FontWeight.Thin,
                        modifier = Modifier.fillMaxWidth().padding(top = 11.dp)
                    )
                }
            }
        }

    }
}

@Composable
fun EmailInputField(isValid: Boolean) {

}


    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Composable
    fun GreetingPreview() {
        WelcomeScreenTheme {
            Greeting("Android")
        }
    }

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isValidPassword1(password: String): Boolean {
    // Regex explanation:
    // (?=.*[0-9])       -> at least one digit
    // (?=.*[a-z])       -> at least one lowercase
    // (?=.*[A-Z])       -> at least one uppercase
    // .{8,}             -> minimum 8 characters
    val passwordRegex = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$")
    return passwordRegex.matches(password)
}
