package com.example.kotlin_module

fun main(){
    val coll = listOf("apple","mango","grapes", "pineapple", "apple")
    val found = coll.filter {
//        it == "apple"
//        it == "pig"
//        it.length>=6
        it.startsWith("p", ignoreCase = true) && it.endsWith(char = 'e')
    }
    println(found)
}