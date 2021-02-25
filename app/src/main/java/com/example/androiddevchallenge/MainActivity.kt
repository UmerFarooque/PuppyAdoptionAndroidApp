/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
import com.example.androiddevchallenge.ui.theme.lightGrey

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                BodyContent(
                    itemClickAction = { index -> launchDetailActivity(this, index) }
                )
            }
        }
    }
}

@Composable
fun BodyContent(
    itemClickAction: (Int) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Pet Shop")
                }
            )
        },
        backgroundColor = lightGrey
    ) {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            itemsIndexed(Repo.getPetsData()) { index, pet ->
                ListItem(pet, index, itemClickAction)
            }
        }
    }
}

@Composable
fun ListItem(dog: Dog, index: Int, itemClickAction: (Int) -> Unit) {
    val typography = MaterialTheme.typography
    Card(
        modifier = Modifier
            .padding(top = 24.dp)
            .clickable {
                itemClickAction(index)
            },
        shape = RoundedCornerShape(8.dp),
    ) {
        Column {
            Image(
                painterResource(id = dog.image),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = dog.name,
                style = typography.h6,
                color = Color.Blue
            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "${dog.age}yrs, ${dog.gender}",
                style = typography.body2
            )
            Text(
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp),
                text = dog.address,
                style = typography.body2,
                fontWeight = FontWeight.ExtraLight
            )
        }
    }
}

fun launchDetailActivity(activity: AppCompatActivity, index: Int) {
    activity.startActivity(
        Intent(activity, DetailActivity::class.java).apply {
            putExtra("index", index)
        }
    )
}
