import domain.*

fun main() {
    moneyCheck1()

//    check4()
//    check5()

//    check2()
//    check3()
//
//    check1()
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

/**
 * 値オブジェクトのはず…？
 */
private fun check4() {
    val rnk0085User = User(
        id = UserId(0),
        name = UserName("rnk0085"),
    )
    println("rnk0085User = $rnk0085User")

    val takenokoUser = rnk0085User.changeUserName(
        other = UserName("takenoko")
    )
    println("takenokoUser = $takenokoUser")

    // 値オブジェクトの場合は全ての属性によって比較される（等価性）
    println("rnk0085User == takenokoUser -> ${rnk0085User == takenokoUser}") // 期待: false
}

/**
 * エンティティにしたかった
 */
private fun check5() {
    val rnk0085 = UserEntity(
        id = UserId(0),
        name = UserName("rnk0085"),
    )
    println("rnk0085 = $rnk0085")

    rnk0085.changeUserName(
        other = UserName("takenoko")
    )
    println("rnk0085 = $rnk0085")

    val temp = UserEntity(
        id = UserId(0),
        name = UserName("rnk0085"),
    )
    println("temp = $temp")

    // エンティティは同一性を表す識別子(id)だけが比較の対象
    println("rnk0085 == temp -> ${rnk0085 == temp}") // 期待: true
}