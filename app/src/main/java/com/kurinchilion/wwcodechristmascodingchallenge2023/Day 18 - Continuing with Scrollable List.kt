package com.kurinchilion.wwcodechristmascodingchallenge2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurinchilion.coursesapp.data.DataSource
import com.kurinchilion.coursesapp.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoursesApp()
                }
            }
        }
    }
}



@Composable
fun CoursesApp () {
    CoursesList(
        coursesList = DataSource.topics
    )
}

@Composable
fun CourseCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(8.dp)) {
        Row  {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.stringResourceId),
                modifier = Modifier.size(68.dp)
            )
            Column {
                Text(
                    text = LocalContext.current.getString(topic.stringResourceId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier.padding(16.dp, 16.dp,16.dp, 8.dp),

                )
                Row {
                    Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = stringResource(id = topic.stringResourceId),
                        modifier = Modifier.padding(16.dp, 0.dp, 8.dp, 0.dp)
                    )
                    Text(
                        text = topic.numberOfCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 0.dp)
                    )
                }

            }
        }
    }
}

@Composable
fun CoursesList(coursesList: List<Topic>, modifier: Modifier = Modifier){
    /**
     * If you know the exact amount of columns to be used, you can provide an instance of
     * GridCells.Fixed containing the number of required columns.
     */

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
    ) {
        items(coursesList){topic ->
            // LazyGridItemSpanScope:
            // maxLineSpan
            CourseCard(
                topic = topic,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseCardPreview() {
    CourseCard(Topic(R.string.architecture, 58 ,R.drawable.architecture))
}
