package com.kurinchilion.wwcodechristmascodingchallenge2023

import android.media.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurinchilion.superheroesapp.model.Hero

@Composable
private fun SuperHeroItem(hero: Hero, modifier: Modifier = Modifier){
    Card {
        Row (
            modifier = modifier.height(72.dp)
                .padding(16.dp)){
            Column {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = stringResource(hero.nameRes),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
        }


    }

}

@Composable
private fun HeroesList(heroesList: List<Hero>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        //A call to the items() method requires a lambda function. In that function, specify a parameter
        // of affirmation that represents one affirmation item from the affirmationList.
        items(heroesList) { hero ->
            SuperHeroItem(
                hero = hero,
                modifier = Modifier.padding(16.dp)
            )
        }
    }

}

@Preview
@Composable
private fun SuperHeroItemPreview(){
    SuperHeroItem(Hero(R.string.hero1, R.string.description1, R.drawable.android_superhero1))
}