package com.example.chitter

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int

public class BirdListFragmentDirections private constructor() {
  private data class ActionBirdListFragmentToBirdDetailsFragment(
    public val birdId: Int,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_birdListFragment_to_birdDetailsFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("birdId", this.birdId)
        return result
      }
  }

  private data class ActionBirdListFragmentToBirdDetailsFragment2(
    public val birdId: Int,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_birdListFragment_to_birdDetailsFragment2

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("birdId", this.birdId)
        return result
      }
  }

  public companion object {
    public fun actionBirdListFragmentToBirdDetailsFragment(birdId: Int): NavDirections =
        ActionBirdListFragmentToBirdDetailsFragment(birdId)

    public fun actionBirdListFragmentToBirdDetailsFragment2(birdId: Int): NavDirections =
        ActionBirdListFragmentToBirdDetailsFragment2(birdId)
  }
}
