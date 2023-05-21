package domain

import kotlin.IllegalArgumentException

/**
 * 値オブジェクトは独自のふるまいを持てる
 */
data class Money(val amount: Double, val currency: String) {
    init {
//        require(amount >= 0) { "Amount must be positive." }
//        require(currency.isNotBlank()) { "Currency must not be blank." }

        // if の方が分かりやすい…？
        if (amount < 0) throw IllegalArgumentException("Amount must be positive.")
        if (currency.isBlank()) throw IllegalArgumentException("Currency must not be blank.")
    }

    operator fun plus(other: Money): Money {
        require(currency == other.currency) { "Currencies do not match." }
        return Money(amount + other.amount, currency)
    }

    operator fun minus(other: Money): Money {
        require(currency == other.currency) { "Currencies do not match." }
        return Money(amount - other.amount, currency)
    }
}

fun moneyCheck1() {
    val usd100 = Money(100.0, "USD")
    val usd50 = Money(50.0, "USD")

    val total = usd100 + usd50
    println(total) // Money(amount=150.0, currency=USD)

    val difference = usd100 - usd50
    println(difference) // Money(amount=50.0, currency=USD)
}