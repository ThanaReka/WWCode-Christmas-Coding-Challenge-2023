package com.kurinchilion.wwcodechristmascodingchallenge2023

package com.kurinchilion.superheroesapp

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurinchilion.superheroesapp.model.Hero

@Composable
private fun SuperHeroItem(hero: Hero, modifier: Modifier = Modifier){
    Card {
        Row {
            Column(modifier = modifier.height(72.dp)) {
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
private fun HeroesList(){

}

@Preview
@Composable
private fun SuperHeroItemPreview(){
    SuperHeroItem(Hero(R.string.hero1, R.string.description1, R.drawable.android_superhero1))
}