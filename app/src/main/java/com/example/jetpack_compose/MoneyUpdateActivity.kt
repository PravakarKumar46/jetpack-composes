package com.example.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose.ui.theme.JetpackcomposeTheme

class MoneyUpdateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposeTheme {
                // A surface container using the 'background' color from the theme
                MyApplication()
            }
        }
    }
}

@Preview
@Composable
fun MyApplication() {

    val moneyCredit = remember {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(),
        color = Color(0xFF546E7A)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${moneyCredit.value}$",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Spacer(modifier = Modifier.height(100.dp))
            CreateCircleButton(moneyCredit = moneyCredit.value) { newValue ->
                moneyCredit.value = newValue
            }
        }

    }

}

@Composable
fun CreateCircleButton(moneyCredit: Int = 0, updateCredit: (Int) -> Unit) {

    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(105.dp)
            .clickable {

                updateCredit(moneyCredit + 1)

//                moneyCredit.value += 1
//                Log.d("pppppppp", "CreateCircleButton: ${moneyCredit.value}")
            },
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )

    ) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(text = "CLICK", modifier = Modifier)
        }

    }


}


/*
/***
 same UI with different way
 */
@Composable
fun MyApp() {
    val dname = remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Blue
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize(),

            ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextUpdate(dname.value)
                CreateButton(dname.value)
            }
        }
    }

}

@Composable
private fun CreateButton(dname: Int) {
    val isButtonClicked = remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Button(onClick = { isButtonClicked.value = !isButtonClicked.value }) {
            Text(text = "Button")
        }
    }

    if (isButtonClicked.value)
        Text(text = "${dname + 100}$")

}

@Composable
fun TextUpdate(res: Int = 0) {
    Text(text = "${res}$", modifier = Modifier.padding(bottom = 10.dp))
}
*/


@Preview(showBackground = true)
@Composable
fun CircleApp() {
    JetpackcomposeTheme {
    }
}