package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.model.Repo
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val index = intent.extras?.getInt("index") ?: 0
        val dog = Repo.getPetsData()[index]
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BodyContent(dog = dog)
                }
            }
        }
    }
}

@Composable
fun BodyContent(dog: Dog) {
    val typography = MaterialTheme.typography
    Column {
        Image(
            painterResource(id = dog.image),
            contentDescription = null,
            modifier = Modifier
                .height(240.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .weight(1F)
                .padding(start = 16.dp, end = 16.dp, top = 24.dp)
        ) {
            Text(
                text = dog.name,
                style = typography.h5,
                color = Color.Blue
            )
            Text(
                text = dog.address,
                style = typography.subtitle2
            )
            Spacer(modifier = Modifier.height(16.dp))
            Divider(modifier = Modifier.height(4.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "GENDER:", fontWeight = FontWeight.Medium)
            Text(text = dog.gender, style = typography.subtitle2, fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.height(16.dp))
            Text("AGE:", fontWeight = FontWeight.Medium)
            Text("${dog.age}yrs", style = typography.subtitle2, fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.height(16.dp))
            Text("DESCRIPTION:", fontWeight = FontWeight.Medium)
            Text(dog.description, style = typography.subtitle2, fontWeight = FontWeight.Light)
        }
    }
}
