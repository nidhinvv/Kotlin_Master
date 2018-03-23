package master.kotlin.dkv.com.kotlin_master.extensions

operator fun <T, R, V> ((T) -> R).rangeTo(other: (R) -> V): ((T) -> V) {
    return {
        other(this(it))
    }
}

fun Int.toBinaryString(): String{
    var n = this
    var binaryNumber: Long = 0
    var remainder: Int
    var i = 1
    var step = 1

    while (n != 0) {
        remainder = n % 2
        n = n / 2
        binaryNumber += (remainder * i).toLong()
        i *= 10
    }
    return binaryNumber.toString()
}