package com.kurinchilion.wwcodechristmascodingchallenge2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kurinchilion.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonApp(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
) {
    var result by remember { mutableStateOf(1) }

    when (result) {
        1 ->     Column(
            modifier = modifier.clickable { result = 2 },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.lemon_tree),
                contentDescription = "1"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                stringResource(R.string.tree_content_description),
                fontSize = 18.sp
            )
        }

        2 -> Column(
            modifier = modifier.clickable { result = 3 },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.lemon_squeeze),
                contentDescription = "2"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                stringResource(R.string.lemon_content_description),
                fontSize = 18.sp
            )
        }
        3 -> Column(
            modifier = modifier.clickable { result = 4 },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.lemon_drink),
                contentDescription = "3"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                stringResource(R.string.drink_content_description),
                fontSize = 18.sp
            )
        }

        else -> Column(
            modifier = modifier.clickable { result = 1 },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.lemon_restart),
                contentDescription = "4"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                stringResource(R.string.start_content_description),
                fontSize = 18.sp
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeTheme {
        LemonApp()
    }
}