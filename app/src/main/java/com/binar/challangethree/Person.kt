package com.binar.challangethree

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
   val name: String,
   var age: String,
   val address: String,
   val job: String

): Parcelable
