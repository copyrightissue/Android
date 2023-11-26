package com.example.chitter

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class BirdDetailsFragmentArgs(
  public val birdId: Int,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("birdId", this.birdId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("birdId", this.birdId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): BirdDetailsFragmentArgs {
      bundle.setClassLoader(BirdDetailsFragmentArgs::class.java.classLoader)
      val __birdId : Int
      if (bundle.containsKey("birdId")) {
        __birdId = bundle.getInt("birdId")
      } else {
        throw IllegalArgumentException("Required argument \"birdId\" is missing and does not have an android:defaultValue")
      }
      return BirdDetailsFragmentArgs(__birdId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): BirdDetailsFragmentArgs {
      val __birdId : Int?
      if (savedStateHandle.contains("birdId")) {
        __birdId = savedStateHandle["birdId"]
        if (__birdId == null) {
          throw IllegalArgumentException("Argument \"birdId\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"birdId\" is missing and does not have an android:defaultValue")
      }
      return BirdDetailsFragmentArgs(__birdId)
    }
  }
}
