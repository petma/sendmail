package cn.maxpeedinggrods.rms.mailServer.maildetail.send

/**
 * Send Email Exception
 *
 * @author biezhi
 * @date 2018/10/9
 */
class SendMailException : Exception {

    constructor()

    constructor(message: String) : super(message)

    constructor(cause: Throwable) : super(cause)
}
