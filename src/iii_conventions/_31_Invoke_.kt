package iii_conventions

import util.TODO


class Invokable {
    var numOfInvocations = 0

    operator fun invoke(): Invokable {
        numOfInvocations++
        return this
    }

    fun getNumberOfInvocations() = numOfInvocations
}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change class Invokable to count the number of invocations (round brackets).
        Uncomment the commented code - it should return 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
    //todoTask31()
    return invokable()()()().getNumberOfInvocations()
}
