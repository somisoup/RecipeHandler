package com.example.recipehandler.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipehandler.classes.Recipe

class SearchViewModel : ViewModel() {
    val searchRecipe = Recipe()
    var searchRating : Float = 0.0F
    lateinit var totalTime: String

    private val _text = MutableLiveData<String>().apply {
        value = "This is the Search Recipes Fragment"
    }
    val text: LiveData<String> = _text

    fun onSearch() {
        searchRecipe.prepTime = totalTime.toInt() / 2
        searchRecipe.cookTime = totalTime.toInt() - searchRecipe.prepTime
        searchRecipe.rating = searchRating.toInt()
        println("${searchRecipe.prepTime} ${searchRecipe.cookTime} ${searchRecipe.rating}")
    }
}