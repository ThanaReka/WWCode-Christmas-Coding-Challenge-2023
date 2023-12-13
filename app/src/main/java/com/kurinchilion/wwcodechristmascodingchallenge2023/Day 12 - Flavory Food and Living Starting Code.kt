package com.kurinchilion.wwcodechristmascodingchallenge2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kurinchilion.flavoryfooddisplayapp.ui.theme.FlavoryFoodDisplayAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlavoryFoodDisplayAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FoodDisplayApp()
                }
            }
        }
    }
}

@Composable
fun FoodDisplayApp(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
) {
    var currentImage by remember { mutableStateOf(1) }

    when (currentImage) {
        1 -> ImageAndDescription(onClick = {currentImage = 2
        },
            R.drawable.carrot_juice,
            R.string.juice_title,
        )

        2 -> ImageAndDescription(onClick = {currentImage = 3},
            R.drawable.golden_halloumi_salad,
            R.string.salad_title,
        )

        3 -> ImageAndDescription(onClick = {currentImage = 4},
            R.drawable.cottage_cake,
            R.string.cake_title,
        )

        4 -> ImageAndDescription(onClick = {currentImage = 5},
            R.drawable.stirfry,
            R.string.stirfry_title,
        )
        5 -> ImageAndDescription(onClick = {currentImage = 1},
            R.drawable.banana_pie,
            R.string.pie_title,
        )
    }
}

@Composable
fun ImageAndDescription (onClick: () -> Unit,
                         relevantImage : Int,
                         relevantDescription : Int,
){

    Column(
        modifier = Modifier.clickable {onClick()},
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(relevantImage),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(15.dp))
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
fun FlavoryFoodPreview() {
    FlavoryFoodDisplayAppTheme {
        FoodDisplayApp()
    }
}