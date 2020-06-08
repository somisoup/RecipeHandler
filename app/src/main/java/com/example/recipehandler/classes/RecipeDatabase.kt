package com.example.recipehandler.classes

import androidx.room.*

@Database(entities = arrayOf(Recipe::class), version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}

object DatabaseRepo {
    lateinit var db: RecipeDatabase
}

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipe")
    fun getAll(): List<Recipe>

    @Insert
    fun insertAll(vararg recipes: Recipe)

    @Delete
    fun delete(recipe: Recipe)
}