package com.example.recipehandler

import android.util.Log
import com.example.recipehandler.classes.*

fun populateDatabase() {
    val cookies = Recipe()
    cookies.rid = 0
    cookies.name = "Sheel's Classic Chocolate Chip Cookies"
    cookies.rating = 5
    cookies.prepTime = 20
    cookies.cookTime = 15
    val cookieIngredient = mutableListOf<Ingredient>()
    cookieIngredient.add(Ingredient("sugar", Quantity(0.5, "cup")))
    cookieIngredient.add(Ingredient("brown sugar", Quantity(0.75, "cup")))
    cookieIngredient.add(Ingredient("salt", Quantity(1.0, "tablespoon")))
    cookieIngredient.add(Ingredient("butter", Quantity(0.5, "cup"), "melted"))
    cookieIngredient.add(Ingredient("egg", Quantity(1.0)))
    cookieIngredient.add(Ingredient("vanilla extract", Quantity(1.0, "teaspoon")))
    cookieIngredient.add(Ingredient("all-purpose flour", Quantity(1.25, "cup")))
    cookieIngredient.add(Ingredient("baking soda", Quantity(0.5, "teaspoon")))
    cookieIngredient.add(Ingredient("chocolate chips"))
    cookies.ingredients = cookieIngredient.toHashSet()
    cookies.steps = listOf<String>("Combine sugar and butter, whisk thoroughly", "Add egg and vanilla, whisk until thin ribbon", "Sift flour, baking soda, and salt. Fold gently (don’t work too hard) until dough forms",
                        "Add chocolate and fold in", "(optional) Place in refrigerator for 1 - 24 hrs", "Place a small ball of dough on a parchment lined baking sheet, spread far apart from one another (since they will melt and expand)",
                        "Place in a pre-heated 350 F oven for 10-12 minutes (take out as soon as sides are golden)", "Let rest on tray until cookie has cooled")
    cookies.cookwareType = hashSetOf<Cookware>(Cookware.BAKE)
    cookies.dietType = hashSetOf<Diet>(Diet.VEGETARIAN, Diet.KOSHER, Diet.NUT_FREE)
    cookies.mealType = hashSetOf<Meal>(Meal.SNACK, Meal.DESSERT)

    val steak = Recipe()
    steak.rid = 1
    steak.name = "Sheel's Steaks (non sous vide)"
    steak.rating = 5
    steak.prepTime = 10
    steak.cookTime = 90
    val steakIngredient = mutableListOf<Ingredient>()
    steakIngredient.add(Ingredient("steak", Quantity(1.0), "at least 1 - 2 inches thick"))
    steakIngredient.add(Ingredient("garlic", Quantity(2.0, "cloves")))
    steakIngredient.add(Ingredient("canola oil", Quantity(2.0, "tablespoon")))
    steakIngredient.add(Ingredient("thyme", Quantity(1.0, "bunch")))
    steakIngredient.add(Ingredient("butter", Quantity(2.0, "tablespoon")))
    steak.ingredients = steakIngredient.toHashSet()
    steak.steps = listOf<String>("Preheat oven to 250 F", "Steak should be at room temperature (take out of fridge for 10 minutes or so, should not be frozen)",
                                    "Pat dry surface of steak, season liberally with salt and pepper", "Place on an oven-safe cooling rack on top of a baking tray and into the oven for 1 hr for medium rare (check temperature using probe to be sure - should register ~ 115 F)",
                                    "Let steak cool, preheat pan (either cast iron or steel) on high heat", "Add oil to hot pan, wait until oil is smoking",
                                    "Add steak to pan, cook one side for 45 seconds", "Flip, then add butter thyme and garlic. Tilt pan towards you and spoon the melted butter, garlic, and thyme onto the steak. Cook this side for 45 - 60 seconds",
                                    "Sear sides of steak, then rest with the garlic, thyme, and juices from the pan for at least 10 minutes")
    steak.cookwareType = hashSetOf<Cookware>(Cookware.BAKE, Cookware.STOVETOP)
    steak.dietType = hashSetOf<Diet>(Diet.KETO, Diet.GLUTEN_FREE, Diet.LOW_CARB, Diet.EGG_FREE, Diet.NUT_FREE, Diet.PALEO)
    steak.mealType = hashSetOf<Meal>(Meal.LUNCH, Meal.DINNER)

    val mash = Recipe()
    mash.rid = 2
    mash.name = "Sheel's Garlicky Mashed Potatoes"
    mash.rating = 5
    mash.prepTime = 15
    mash.cookTime = 25
    val mashIngredient = mutableListOf<Ingredient>()
    mashIngredient.add(Ingredient("garlic"))
    mashIngredient.add(Ingredient("russet potatoes"))
    mashIngredient.add(Ingredient("chives"))
    mashIngredient.add(Ingredient("butter"))
    mashIngredient.add(Ingredient("extra virgin olive oil"))
    mash.ingredients = mashIngredient.toHashSet()
    mash.steps = listOf<String>("(optional) Peel potatoes", "Chop potatoes into smaller pieces and place into a pot with water.",
                                "Boil potatoes until tender", "Meanwhile, crush or slice garlic into chunks and add into a small pan with EVOO. Place on low heat and fry garlic until golden brown (flip garlic if not fully covered by oil)",
                                "Remove fried garlic from pan, reserve oil", "Drain water from potato pot once done and add butter",
                                "Mash potatoes and butter, add the reserved oil until desired consistency", "Finely chop fried garlic and chives and add to potatoes")
    mash.cookwareType = hashSetOf<Cookware>(Cookware.STOVETOP)
    mash.dietType = hashSetOf<Diet>(Diet.VEGETARIAN, Diet.EGG_FREE, Diet.NUT_FREE)
    mash.mealType = hashSetOf<Meal>(Meal.LUNCH, Meal.DINNER, Meal.SIDE)

    DatabaseRepo.db.recipeDao().insertAll(steak, cookies, mash)
}

fun readAndPrintDb() {
    val database : List<Recipe> = DatabaseRepo.db.recipeDao().getAll()
    database.forEach {
        Log.d("Database", it.name)
        println()
    }
}