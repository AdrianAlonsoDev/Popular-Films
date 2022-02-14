package es.programacionmultimedia.debug

import android.util.Log
import javax.inject.Inject

class DebugLog @Inject constructor() {


    fun log(message: String) {
        Log.d("[DEBUG] ", message)
    }

    fun logError(message: String) {
        Log.d("[ERROR] ", message)
    }

    fun logNetworkError(message: String) {
        Log.d("[NETWORK-ERROR] ", message)
    }
}