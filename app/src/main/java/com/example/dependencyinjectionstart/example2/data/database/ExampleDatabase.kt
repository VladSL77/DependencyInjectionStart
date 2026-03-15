package com.example.dependencyinjectionstart.example2.data.database

import android.content.Context
import android.util.Log
import com.example.dependencyinjectionstart.R
import javax.inject.Inject

class ExampleDatabase @Inject constructor(
    private val context: Context,
    private val currentTime: Long
) {

    fun method() {
        Log.d(LOG_TAG, "ExampleDatabase name: ${context.getString(R.string.app_name)} time: $currentTime")
    }

    companion object {

        private const val LOG_TAG = "EXAMPLE_TEST"
    }
}
