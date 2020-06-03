package com.example.recipehandler.classes

// Diet filters
enum class Diet(val type: String)
{
    VEGETARIAN("vegetarian"),
    VEGAN("vegan"),
    GLUTEN_FREE("gluten free"),
    KETO("keto"),
    LOW_CARB("low carb"),
    DAIRY_FREE("dairy free"),
    KOSHER("kosher"),
    EGG_FREE("egg free"),
    NUT_FREE("nut free"),
    PALEO("paleo"),
    DIABETES_FRIENDLY("diabetes friendly")
}

// Meal type filters
enum class Meal(val type: String)
{
    BREAKFAST("breakfast"),
    LUNCH("lunch"),
    DINNER("dinner"),
    DESSERT("dessert"),
    SNACK("snack"),
    ADD_ON("add-on"),
    SIDE("side")
}

// Cookware type filters
enum class Cookware(val type: String)
{
    BAKE("bake"),
    STOVETOP("stovetop"),
    SLOW_COOKER("slow cooker"),
    PRESSURE_COOKER("pressure cooker"),
    GRILL("grill"),
    GRIDDLE("griddle"),
    FRYER("fryer")
}

// Search filters type enum TODO - (do I really need this? maybe expand this later)
enum class SearchResults(val result: Int)
{
    FULL_MATCH(5), // contains all ingredients and quantities
    MISSING_QUANTITIES(3), // has ingredients, but not the right quantities
    NO_MATCH(0) // no match
}

