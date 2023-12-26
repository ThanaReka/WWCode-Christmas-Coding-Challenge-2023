package com.kurinchilion.wwcodechristmascodingchallenge2023

package com.kurinchilion.superheroesapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kurinchilion.superheroesapp.model.HeroesRepository
import com.kurinchilion.superheroesapp.ui.theme.SuperheroesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperHeroesApp()
                }
            }
        }
    }
}

@Composable
fun SuperHeroesTopAppBar(modifier: Modifier = Modifier) {
    TODO("Not yet implemented")
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = modifier
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SuperHeroesApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SuperHeroesTopAppBar()
        }
    ) {
//        it ->
//        LazyColumn(contentPadding = it) {
//            items(heroes) {
//                SuperHeroItem(
//                    hero = it,
//                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding))
//                )
//            }
//        }
        HeroesList(heroesList = HeroesRepository.heroes)
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperheroesAppTheme {
        SuperHeroesApp()
    }
}

@Composable
fun SuperHeroItem(hero: Hero, modifier: Modifier = Modifier){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.elevation)
        ),
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding))
            .height(dimensionResource(R.dimen.layout_height))

    ) {
        Box(modifier = Modifier.height(dimensionResource(R.dimen.layout_height))) {
            Row {
                Column {
                    Text(
                        text = stringResource(hero.nameRes),
//                        style = MaterialTheme.typography.displaySmall
                    )
                    Text(
                        text = stringResource(hero.descriptionRes),
//                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = stringResource(hero.nameRes),
                    modifier = modifier
                        .padding(dimensionResource(R.dimen.padding), 0.dp, 0.dp, 0.dp)
                        .clip(MaterialTheme.shapes.medium)
                )
            }
        }

    }

}

@Composable
public fun HeroesList(heroesList: List<Hero>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(heroesList) { hero ->
            SuperHeroItem(
                hero = hero,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding), dimensionResource(R.dimen.list_padding))
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun SuperHeroItemPreview(){
    SuperHeroItem(Hero(R.string.hero1, R.string.description1, R.drawable.android_superhero1))
}

@Preview(showBackground = true)
@Composable
private fun HeroesListPreview(){
    HeroesList(heroesList = HeroesRepository.heroes, modifier = Modifier)
}