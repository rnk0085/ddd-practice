import domain.User
import domain.UserId
import domain.UserName

fun main() {
    check1()
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