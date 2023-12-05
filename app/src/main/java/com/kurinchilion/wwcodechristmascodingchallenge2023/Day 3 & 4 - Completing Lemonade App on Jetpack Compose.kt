package com.kurinchilion.wwcodechristmascodingchallenge2023

/*
Day 4 - Cleaning up code from Day 3 to incorporate a reusable composable for repeated code,
adding background with border to image
and adding squeeze logic to prompt user to tap a certain number of times
(using a random number between 2 - 4)
 */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
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
    var currentStep by remember { mutableStateOf(1) }

    var numberOfTaps by remember { mutableStateOf(0) }

    when (currentStep) {
        1 -> LemonTextAndImage(onClick = {currentStep = 2
            numberOfTaps = (2..4).random()
        },
            R.drawable.lemon_tree,
            "1",
            R.string.tree_content_description )

        2 -> LemonTextAndImage(onClick = {numberOfTaps--
            if(numberOfTaps == 0){currentStep = 3}},
            R.drawable.lemon_squeeze,
            "2",
            R.string.lemon_content_description )

        3 -> LemonTextAndImage(onClick = {currentStep = 4},
            R.drawable.lemon_drink,
            "3",
            R.string.drink_content_description )

        4 -> LemonTextAndImage(onClick = {currentStep = 1},
            R.drawable.lemon_restart,
            "4",
            R.string.start_content_description )

    }

}

@Composable
fun LemonTextAndImage(onClick: () -> Unit,
                      relevantImage : Int,
                      contentDescription :String,
                      relevantDescription : Int,
){

    Column(
        modifier = Modifier.clickable {onClick()},
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(relevantImage),
            contentDescription = contentDescription,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(15.dp))
                .border(5.dp, colorResource(R.color.border_green))
                .background(colorResource(R.color.border_green))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            stringResource(relevantDescription),
            fontSize = 18.sp
        )

    }


}
@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeTheme {
        LemonApp()
    }
}