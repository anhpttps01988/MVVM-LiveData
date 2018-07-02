package com.example.anhptt.firststepmvvm.data.source.response

import java.io.Serializable

class Book : Serializable {

    var gtin14: String? = null
    var name: String? = null
    var author: String? = null
    var format: String? = null
    var publisher: String? = null
    var pages: Int = 0
    var brand_name: String? = null
    var size: String? = null
    var serving_size: String? = null
    var servings_per_container: String? = null
    var calories: Int = 0
    var fat_calories: Int = 0
    var fat: String? = null
    var saturated_fat: String? = null
    var trans_fat: String? = null
    var polyunsaturated_fat: String? = null
    var monounsaturated_fat: String? = null
    var cholesterol: Int = 0
    var sodium: Int = 0
    var carbohydrate: Int = 0
    var fiber: Int = 0
    var sugars: Int = 0
    var protein: Int = 0
    var potassium: Int = 0

}