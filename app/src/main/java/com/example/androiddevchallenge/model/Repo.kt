package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.example.androiddevchallenge.R

object Repo {
    fun getPetsData() = petList
}

@Immutable
data class Dog(
    val name: String,
    val age: String,
    val gender: String,
    val description: String,
    val address: String,
    @DrawableRes val image: Int,
)

private val petList = listOf(
    Dog("Bella",
        "2",
        "Female",
        "Bella is a sweet puppy. She has been at shelter since she was born and we'd really love to see her get into a new home soon!. She gets along well with other pets, and is used to being around dogs.",
        "New York",
        R.drawable.dog1),
    Dog("Max",
        "1",
        "Male",
        "Max is a sweet puppy. He has been at shelter since he was born and we'd really love to see him get into a new home soon!. He gets along well with other pets, and is used to being around dogs.",
        "New York",
        R.drawable.dog2),
    Dog("Rocky",
        "2",
        "Male",
        "Max is a sweet puppy. He has been at shelter since he was born and we'd really love to see him get into a new home soon!. He gets along well with other pets, and is used to being around dogs.",
        "New York",
        R.drawable.dog3),
    Dog("Lola",
        "2",
        "Female",
        "Bella is a sweet puppy. She has been at shelter since she was born and we'd really love to see her get into a new home soon!. She gets along well with other pets, and is used to being around dogs.",
        "New York",
        R.drawable.dog4),
    Dog("Maggie",
        "2",
        "Female",
        "Bella is a sweet puppy. She has been at shelter since she was born and we'd really love to see her get into a new home soon!. She gets along well with other pets, and is used to being around dogs.",
        "New York",
        R.drawable.dog5),
    Dog("Toby",
        "1",
        "Male",
        "Max is a sweet puppy. He has been at shelter since he was born and we'd really love to see him get into a new home soon!. He gets along well with other pets, and is used to being around dogs.",
        "New York",
        R.drawable.dog6),
    Dog("Molly",
        "1",
        "Female",
        "Bella is a sweet puppy. She has been at shelter since she was born and we'd really love to see her get into a new home soon!. She gets along well with other pets, and is used to being around dogs.",
        "New York",
        R.drawable.dog7),
    Dog("Bentley",
        "1",
        "Male",
        "Max is a sweet puppy. He has been at shelter since he was born and we'd really love to see him get into a new home soon!. He gets along well with other pets, and is used to being around dogs.",
        "New York",
        R.drawable.dog8),
    Dog("Jack",
        "1",
        "Male",
        "Max is a sweet puppy. He has been at shelter since he was born and we'd really love to see him get into a new home soon!. He gets along well with other pets, and is used to being around dogs.",
        "New York",
        R.drawable.dog9),
    Dog("Lucy",
        "2",
        "Female",
        "Bella is a sweet puppy. She has been at shelter since she was born and we'd really love to see her get into a new home soon!. She gets along well with other pets, and is used to being around dogs.",
        "New York",
        R.drawable.dog10),
)
