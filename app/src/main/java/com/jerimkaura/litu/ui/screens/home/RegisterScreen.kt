package com.jerimkaura.litu.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jerimkaura.litu.R
import com.jerimkaura.litu.ui.Route
import com.jerimkaura.litu.ui.theme.LituTheme

@Composable
fun RegisterScreen(navController: NavController) {
    LituTheme {
        Scaffold(
            content = { paddingValues ->
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 60.dp),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        LitudianLogo()
                        AuthTabs(navController)
                    }
                }
            }
        )
    }
}

@Composable
fun AuthTabs(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }
    val borderColor = if (isSystemInDarkTheme()) {
        Color(0xff202121)
    } else {
        Color(0xffEFEEEF)
    }

    val list = listOf("LOGIN", "REGISTER")
    Column(modifier = Modifier.padding(0.dp)) {
        TabRow(selectedTabIndex = selectedIndex,
            backgroundColor = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.background,
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 8.dp)
                .clip(RoundedCornerShape(60))
                .border(1.dp, color = borderColor, RoundedCornerShape(50)),
            indicator = {
                Box {}
            }
        ) {
            list.forEachIndexed { index, text ->
                val selected = selectedIndex == index
                Tab(
                    modifier = if (selected) Modifier
                        .clip(RoundedCornerShape(50))
                        .background(
                            Color(0xffFF9202)
                        )
                    else Modifier
                        .clip(RoundedCornerShape(50))
                        .background(
                            MaterialTheme.colors.background
                        ),
                    selected = selected,
                    onClick = { selectedIndex = index },
                    text = {
                        Text(
                            text = text,
                            color = if (selected) Color.White else Color(0xffFF9202)
                        )
                    }
                )
            }
        }
        if (selectedIndex == 0) {
            LoginForm(navController)
        } else {
            RegistrationForm(navController)

        }
    }

}


@Composable
fun RegistrationForm(navController: NavController) {
    val borderColor = if (isSystemInDarkTheme()) {
        Color(0xff202121)
    } else {
        Color(0xffEFEEEF)
    }
    Column(
        modifier = Modifier.padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val firstName = remember { mutableStateOf("") }
        val lastName = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val confirmPassword = remember { mutableStateOf("") }

        OutlinedTextField(
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                focusedIndicatorColor = borderColor,
                unfocusedIndicatorColor = borderColor,
            ),
            value = firstName.value,
            onValueChange = { firstName.value = it },
            label = { Text(text = "Enter Firstname", fontWeight = FontWeight.Light) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = RoundedCornerShape(10.dp)

        )
        OutlinedTextField(
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                focusedIndicatorColor = borderColor,
                unfocusedIndicatorColor = borderColor,
            ),
            value = lastName.value,
            onValueChange = { lastName.value = it },
            label = { Text(text = "Enter Lastname", fontWeight = FontWeight.Light) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = RoundedCornerShape(10.dp)
        )
        OutlinedTextField(
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                focusedIndicatorColor = borderColor,
                unfocusedIndicatorColor = borderColor,
            ),
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text(text = "Enter Email", fontWeight = FontWeight.Light) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = RoundedCornerShape(10.dp)
        )
        OutlinedTextField(
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                focusedIndicatorColor = borderColor,
                unfocusedIndicatorColor = borderColor,
            ),
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text(text = "Enter Password", fontWeight = FontWeight.Light) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = RoundedCornerShape(10.dp)
        )
        OutlinedTextField(
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                focusedIndicatorColor = borderColor,
                unfocusedIndicatorColor = borderColor,
            ),
            value = confirmPassword.value,
            onValueChange = { confirmPassword.value = it },
            label = { Text(text = "Confirm Password", fontWeight = FontWeight.Light) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = RoundedCornerShape(10.dp)
        )
        OutlinedButton(
            modifier = Modifier
                .padding(10.dp)
                .wrapContentWidth()
                .padding(5.dp),
            onClick = { navController.navigate(Route.CartScreen.route) },
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "CREATE ACCOUNT")
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_circle_right),
                contentDescription = "Localized description",
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Text(
            text = "By clicking CREATE ACCOUNT you agree with our terms of service stipulated HERE.",
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LoginForm(navController: NavController) {
    val borderColor = if (isSystemInDarkTheme()) {
        Color(0xff202121)
    } else {
        Color(0xffEFEEEF)
    }
    Column(
        modifier = Modifier.padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }


        OutlinedTextField(
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                focusedIndicatorColor = borderColor,
                unfocusedIndicatorColor = borderColor,
            ),
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text(text = "Enter Email", fontWeight = FontWeight.Light) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = RoundedCornerShape(10.dp)
        )
        OutlinedTextField(
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                focusedIndicatorColor = borderColor,
                unfocusedIndicatorColor = borderColor,
            ),
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text(text = "Enter Password", fontWeight = FontWeight.Light) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = RoundedCornerShape(10.dp)
        )

        OutlinedButton(
            modifier = Modifier
                .padding(10.dp)
                .wrapContentWidth()
                .padding(5.dp),
            onClick = { navController.navigate(Route.CartScreen.route) },
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "LOGIN")
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_circle_right),
                contentDescription = "Localized description",
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }

}

@Composable
fun LitudianLogo() {
    val painter = painterResource(id = R.drawable.litudian)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 50.dp)
            .height(100.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(painter = painter, contentDescription = "Litudian Logo")
    }

}
