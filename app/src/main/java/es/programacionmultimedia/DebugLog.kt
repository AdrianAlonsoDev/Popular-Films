package es.programacionmultimedia

import android.util.Log
import javax.inject.Inject

class DebugLog @Inject constructor() {
    fun log(message: String) {
        Log.d("[DEBUG] ", message)
    }
}