package es.programacionmultimedia

import android.util.Log
import es.programacionmultimedia.domain.model.MessageType
import es.programacionmultimedia.domain.repository.LoggerRepository
import es.programacionmultimedia.domain.usecase.PrintMessageUseCase
import javax.inject.Inject

class DebugLog @Inject constructor() {

    @Inject
    lateinit var logger: PrintMessageUseCase

    fun log(message: String) {
        Log.d("[DEBUG] ", message)
        logger.execute(message, MessageType.NORMAL)
    }
    fun logError(message: String) {
        Log.d("[ERROR] ", message)
        logger.execute(message, MessageType.ERROR)

    }

    fun logNetworkError(message: String) {
        Log.d("[NETWORK-ERROR] ", message)
        logger.execute(message, MessageType.NETWORKERROR)

    }
}