package com.example.recipehandler.classes

import androidx.room.ColumnInfo

// Class for storing quantity of ingredient (amount + unit of measurement)
data class Quantity(@ColumnInfo(name = "amount") val amount: Double,
                    @ColumnInfo(name = "unit") val unit: String = "")
{
    // Display as string
    override fun toString() : String{
        return if (amount > 0.0) "${if(amount % 1.0 == 0.0) amount.toInt() else amount}" + if (unit != "") " ${if (amount > 1.0) unit + "s" else unit} " else "" else ""
    }

    // Is equals function
    fun equals(compare: Quantity) : Boolean
    {
        return (this.amount == compare.amount) && (this.unit == compare.unit)
    }

    // Compare to function, used for heuristics for ordered search results
    fun compareTo(compare: Quantity) : Int
    {
        var ret: Int = 0
        ret = if (this.unit != compare.unit) {
            -999 // TODO - maybe change value later?
        }
        else {
            this.amount.compareTo(compare.amount)
        }

        return ret
    }
}
