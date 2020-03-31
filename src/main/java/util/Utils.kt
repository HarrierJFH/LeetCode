package util

fun timeCostCompare(fun1: () -> Any?, fun2: () -> Any?, loops: Int) {
    var start = System.currentTimeMillis()
    for (i in 1..loops) {
        fun1.invoke()
    }
    println("fun1 cost=${System.currentTimeMillis() - start}ms")
    start = System.currentTimeMillis()
    for (i in 1..loops) {
        fun2.invoke()
    }
    println("fun2 cost=${System.currentTimeMillis() - start}ms")
}