package es.programacionmultimedia.domain.repository

import es.programacionmultimedia.domain.model.Film
import es.programacionmultimedia.domain.model.Message
import es.programacionmultimedia.domain.model.MessageType
import jdk.internal.org.jline.utils.Log
import jdk.nashorn.internal.runtime.logging.DebugLogger
import javax.inject.Inject

/*
 * Film Repository interface
 */
interface LoggerRepository {


    /*
     * print function which prints a message with a type of importance.
     */
    fun printLog(message: String, messageType: MessageType) {
            when(messageType) {
                MessageType.NORMAL -> Log.debug("[DEBUG <ERROR>] $message")
                MessageType.ERROR -> Log.debug("[DEBUG <ERROR>] $message")
                MessageType.NETWORKERROR -> Log.debug("[DEBUG <NETWORK-ERROR>] $message")
            }
    }


}