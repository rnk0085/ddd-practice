import domain.BadUserName
import domain.User
import domain.UserId
import domain.UserName

fun main() {
    check2()

    check3()
}

/**
 * UserName にルールを追加した影響を確かめる
 */
private fun check1() {
    val user1 = User(
        id = UserId(0),
        name = UserName("rnk0085"),
    )

    val user2 = User(
        id = UserId(0),
        name = UserName("rnk"),
    )

    println(user1) // OK
    println(user2) // エラー：Exception in thread "main" java.lang.IllegalArgumentException: ユーザー名は5文字以上です
}

/**
 * UserName が自身の値を変更する？
 */
private fun check2() {
    val rnk0085 = UserName("rnk0085")
    println("rnk0085 = $rnk0085")

    val takenoko = rnk0085.changeUserName("takenoko")
    println("takenoko = $takenoko")
}

/**
 * 自分自身の値を変えると気持ちの悪いことに…
 */
private fun check3() {
    val rnk0085 = BadUserName("rnk0085")
    println("rnk0085 = $rnk0085")

    rnk0085.changeUserName("takenoko")
    println("rnk0085 = $rnk0085")
}