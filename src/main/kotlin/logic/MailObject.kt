package logic

/**
 * Template for mailobject used as mail container for messages
 */
class MailObject (
    val recipients :String,
    val subject: String,
    val body: String,
    val attachments :String,
    val moment :String
        )