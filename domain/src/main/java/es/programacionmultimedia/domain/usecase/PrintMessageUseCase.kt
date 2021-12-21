package es.programacionmultimedia.domain.usecase

import es.programacionmultimedia.domain.model.MessageType
import es.programacionmultimedia.domain.repository.LoggerRepository
import javax.inject.Inject

class PrintMessageUseCase @Inject constructor(
    private val loggerRepository: LoggerRepository
) {
    fun execute(message: String, messageType: MessageType) = loggerRepository.printLog(message, messageType)
}