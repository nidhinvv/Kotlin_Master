package master.kotlin.dkv.com.kotlin_master.log

import android.util.Log
import master.kotlin.dkv.com.kotlin_master.config.Config


interface Logger {
    val tag: String
        get() { return javaClass.simpleName }
}

private inline fun log(level: Int, logger: Logger, message: Any?, f: (String, String) -> Unit) {
    if (Log.isLoggable(logger.tag, level) && Config.IS_LOG_ENABLED) {
        f(logger.tag, message?.toString() ?: "null")
    }
}

fun Logger.warn(message: Any?){
    log(Log.WARN, this, message, {tag, msg-> Log.w(tag, msg) })
}

fun Logger.info(message: Any?){
    log(Log.INFO, this, message, {tag, msg-> Log.i(tag, msg) })
}

fun Logger.debug(message: Any?){
    log(Log.DEBUG, this, message, {tag, msg-> Log.d(tag, msg) })
}

fun Logger.verbose(message: Any?){
    log(Log.VERBOSE, this, message, {tag, msg-> Log.v(tag, msg) })
}

fun Logger.error(message: Any?){
    log(Log.ERROR, this, message, {tag, msg-> Log.e(tag, msg) })
}