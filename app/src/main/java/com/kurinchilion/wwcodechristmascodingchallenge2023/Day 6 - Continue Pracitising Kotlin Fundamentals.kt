package com.kurinchilion.wwcodechristmascodingchallenge2023

/*
* Temperature converter
* There are three main temperature scales used in the world: Celsius, Fahrenheit, and Kelvin.
* Write a program that converts a temperature
* from one scale to another with these formulas:
* Celsius to Fahrenheit: ° F = 9/5 (° C) + 32
* Kelvin to Celsius: ° C = K - 273.15
* Fahrenheit to Kelvin: K = 5/9 (° F - 32) + 273.15
* Note that the String.format("%.2f", /* measurement */ ) method is used to convert a number into a
* String type with 2 decimal places.
* Complete the main() function so that it calls the printFinalTemperature() function and prints the
* following lines. You need to pass arguments for the temperature and conversion formula.
 */

fun main() {
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") {9.0/5.0 * 27.0 + 32.0}
    printFinalTemperature(350.0, "Kelvin", "Celsius") {350.0 - 273.15}
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin"){5.0/9.0 *(10.0 - 32.0) + 273.15}
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

/*
* Song catalog
*
* Imagine that you need to create a music-player app.
*
* Create a class that can represent the structure of a song. The Song class must include these code elements:
*
* Properties for the title, artist, year published, and play count
* A property that indicates whether the song is popular. If the play count is less than 1,000, consider it unpopular.
* A method that prints a song description in this format:
* "[Title], performed by [artist], was released in [year published]."
 */


//fun main() {
//    val song = Song("Sahayane", "Shreya Ghosal", 2009, 10000)
//    song.printSong()
//    println(song.isPopular)
//
//}

class Song(
    var title: String,
    var artist: String,
    var yearPublished: Int,
    var playCount: Int
){
    var isPopular: Boolean = false

    fun printPlayCount(){
        if (playCount > 1000){
            isPopular
        }

    }
    fun printSong(){
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}

