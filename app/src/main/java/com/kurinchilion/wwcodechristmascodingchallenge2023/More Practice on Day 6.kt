package com.kurinchilion.wwcodechristmascodingchallenge2023

/*
 * Internet profile
 * Oftentimes, you're required to complete profiles for online websites that contain mandatory and non-mandatory fields.
 * For example, you can add your personal information and link to other people who referred you to sign up for the profile.
 * In the initial code provided in the following code snippet, write a program which prints out a person's profile details.
 */


//fun main() {
//    val amanda = Person("Amanda", 33, "play tennis", null)
//    val atiqah = Person("Atiqah", 28, "climb", amanda)
//
//    amanda.showProfile()
//    atiqah.showProfile()
//}
//
//
//class Person(val name: String,
//             val age: Int,
//             val hobby: String?,
//             val referrer: Person?) {
//    fun showProfile() {
//        // Fill in code
//        println("Name: $name")
//        println("Age: $age")
//        print("Likes to ${hobby}. ")
//        if (referrer == null){
//            print("Doesn't have a referrer.")
//        } else {
//            print("Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}.")
//        }
//        print("\n\n")
//    }
//}


/*
* Foldable phones

Typically, a phone screen turns on and off when the power button is pressed.
* In contrast, if a foldable phone is folded, the main inner screen on a foldable phone doesn't turn
* on when the power button is pressed.
*
* In the initial code provided in the following code snippet, write a FoldablePhone class that
* inherits from the Phone class. It should contain the following:
* A property that indicates whether the phone is folded.
* A different switchOn() function behavior than the Phone class so that it only turns the screen on
* when the phone isn't folded.
*
* Methods to change the folding state.


 */
open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    open fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(private var isFolded: Boolean = true) : Phone(){
    override fun switchOn(){
        if(isFolded){
            isScreenLightOn = false
        }
    }
    fun fold() {
        isFolded = true
    }

    fun unfold() {
        isFolded = false
    }
}

fun main() {
    val newFoldablePhone = FoldablePhone()

    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.unfold()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
}



