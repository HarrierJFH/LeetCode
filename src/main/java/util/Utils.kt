package util

fun timeCost(function: () -> Any?, loops: Int = 1): Any? {
    var result: Any? = null
    val start = System.currentTimeMillis()
    for (i in 1..loops) {
        result = function.invoke()
    }
    println("cost=${System.currentTimeMillis() - start}ms")
    return result
}

fun timeCostCompare(fun1: () -> Any?, fun2: () -> Any?, loops: Int) {
    timeCost(fun1, loops)
    timeCost(fun2, loops)
}