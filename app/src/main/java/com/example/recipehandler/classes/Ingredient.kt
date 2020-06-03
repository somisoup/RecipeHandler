package com.example.recipehandler.classes

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

// Class for ingredients
data class Ingredient(val name: String)
{
    @PrimaryKey val ingId: Int = 0
    @ColumnInfo(name = "quantity") var quantity: Quantity = Quantity(0.0)
    @ColumnInfo(name = "addtl_info") var addtlInfo: String = "none"

    // Creating a secondary constructor because I only want to check name value in equals (I think??)
    constructor (type: String, quantity: Quantity, addtlInfo: String = "") : this(type) {
        this.quantity = quantity
        this.addtlInfo = addtlInfo
    }

    // Equals function to compare Ingredients (only compare names for now)
    fun equals(compare: Ingredient) : Boolean
    {
        return this.name == compare.name
    }

    // For displaying purposes
    override fun toString() : String
    {
        return "$quantity $name, $addtlInfo"
    }

    // To compare Ingredients for retrieval/search purposes
    fun compareTo(compare: Ingredient) : Int
    {
        var ret: Int = 0
        ret = if (this.name == compare.name)
        {
            this.quantity.compareTo(compare.quantity)
        }
        else
        {
            -998
        }

        return ret
    }

    // For displaying purposes
    fun display(bullet: Boolean = false)
    {
        if (bullet) {
            print("- ")
        }
        println("$this")
    }
}