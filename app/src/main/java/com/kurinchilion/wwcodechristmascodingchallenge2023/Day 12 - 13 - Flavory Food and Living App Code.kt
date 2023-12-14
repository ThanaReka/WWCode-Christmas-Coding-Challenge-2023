package com.kurinchilion.wwcodechristmascodingchallenge2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
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
                    FoodDisplayApp({ /*TODO*/ })
                }
            }
        }
    }
}

@Composable
fun FoodDisplayApp(
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
    var currentImage by
    remember { mutableStateOf(1) }

    when (currentImage) {
        1 -> ImageAndDescription(onClickNext = {currentImage = 2 },
            onClickPrevious = {currentImage = 5},
            R.drawable.carrot_juice,
            R.string.juice_title,
        )

        2 -> ImageAndDescription(onClickNext = {currentImage = 3},
            onClickPrevious = {currentImage = 1},
            R.drawable.golden_halloumi_salad,
            R.string.salad_title,
        )

        3 -> ImageAndDescription(onClickNext = {currentImage = 4},
            onClickPrevious = {currentImage = 2},
            R.drawable.cottage_cake,
            R.string.cake_title,
        )

        4 -> ImageAndDescription(onClickNext = {currentImage = 5},
            onClickPrevious = {currentImage = 3},
            R.drawable.stirfry,
            R.string.stirfry_title,
        )
        5 -> ImageAndDescription(onClickNext = {currentImage = 1},
            onClickPrevious = {currentImage = 4},
            R.drawable.banana_pie,
            R.string.pie_title,
        )
    }
}

@Composable
fun ImageAndDescription (onClickNext: () -> Unit,
                         onClickPrevious: () -> Unit,
                         relevantImage : Int,
                         relevantDescription : Int,
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(relevantImage),
            contentDescription = null,
            modifier = Modifier
                .size(350.dp)
                .clip(RoundedCornerShape(15.dp))
                .border(5.dp, colorResource(id = R.color.border_grey))
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            stringResource(relevantDescription),
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(25.dp, 0.dp, 25.dp, 0.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(colorResource(id = R.color.light_grey))
        )

        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(150. dp)
        ) {
            Button(onClick = {onClickPrevious()},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {
                Text(stringResource(R.string.previous_btn))
//                currentImage--
            }

            Button(onClick = {onClickNext()},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )) {
                Text(stringResource(R.string.next_btn))
//                currentImage++
            }
        }

    }


}

@Preview(showBackground = true)
@Composable
fun FlavoryFoodPreview() {
    FlavoryFoodDisplayAppTheme {
        FoodDisplayApp({ /*TODO*/ })
    }
}