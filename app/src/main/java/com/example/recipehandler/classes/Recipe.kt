package com.example.recipehandler.classes

import androidx.room.*

// Class for storing a recipe
@Entity
class Recipe
{
    @PrimaryKey var rid: Int = 0
    @ColumnInfo(name = "name") var name : String = ""
    @ColumnInfo(name = "rating") var rating : Int = 0
    @ColumnInfo(name = "prep_time") var prepTime : Int = 0
    @ColumnInfo(name = "cook_time") var cookTime : Int = 0
    /*
    @Relation(
        parentColumn = "rid",
        entityColumn = "ingId"
    )
    */
    //@ColumnInfo(name = "ingredients")
    @Ignore
    var ingredients : HashSet<Ingredient> = HashSet<Ingredient>()
    //@ColumnInfo(name = "steps")
    @Ignore
    var steps : List<String> = emptyList<String>()
    //@ColumnInfo(name = "diet_type")
    @Ignore
    var dietType : HashSet<Diet> = HashSet<Diet>()
   // @ColumnInfo(name = "meal_type")
    @Ignore
    var mealType : HashSet<Meal> = HashSet<Meal>()
   // @ColumnInfo(name = "cookware_type")
    @Ignore
    var cookwareType : HashSet<Cookware> = HashSet<Cookware>()

    // Check passed in ingredients list (aka what the user has in stock) with
    // ingredients required for recipe. Return a number which can be used to
    // sort recipe with how viable it is with user's ingredients
    fun doIngredientsMatch(stock : HashSet<Ingredient>) : Int
    {
        // bad search and compare algorithm, need to improve later IMO
        var sum : Int = 0

        stock.forEach{
            sum += if (ingredients.contains(it)) {
                SearchResults.FULL_MATCH.result
            } else {
                SearchResults.NO_MATCH.result
            }
        }

        return sum / ingredients.size
    }


    // Displays recipe in human readable format
    fun displayHuman()
    {
        // Display name and rating
        println(name)
        print("Rating : ")
        repeat(rating)
        {
            print("*")
        }
        if (rating == 0)
        {
            print("NR")
        }
        println()

        // Display cook/prep time
        println("Prep time: $prepTime minutes")
        println("Cook time: $cookTime minutes")
        println()

        // Display ingredients
        println("Ingredients:")
        ingredients.forEach()
        {
            it.display(true)
        }
        println()

        // Display steps
        println("Steps:")
        for((index, value) in steps.withIndex())
        {
            println("${index+1}. $value")
        }
        println()

        // Display recipe attributes
        print("This meal is ")
        dietType.forEach()
        {
            print("${it.type} ")
        }
        println()
        print("This meal can be prepared for (and/or as) ")
        mealType.forEach()
        {
            print("${it.type} ")
        }
        println()
        print("This recipe requires ")
        cookwareType.forEach()
        {
            print("${it.type} ")
        }
        println()
    }
}
