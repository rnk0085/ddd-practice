package domain

/**
 * ルールが存在している
 * UserName は「5文字以上」であることが保証される
 *
 * Memo: Value class primary constructor must only have final read-only (val) property parameters
 */
@JvmInline
value class UserName(
    private val name: String,
) {
    init {
        require(name.length >= 5) { "ユーザー名は5文字以上です" }
    }

    /**
     * TODO: 値オブジェクトなので自身を変更するふるまいはNG？
     * これって「代入」にあたるかも？
     *
     * そもそもわざわざ作る必要ない。新しくUserNameを作れば良い。
     * val aaa = UserName("aaa")
     * val bbb = aaa.changeUserName("bbb")
     *  -> val bbb = UserName("bbb") で良いじゃん…。
     */
    fun changeUserName(other: String) : UserName {
        return UserName(other)
    }

//    fun changeUserName2(other: String) {
//        // FIXME: Val cannot be reassigned
//        this.name = other
//    }
}

/**
 * FIXME: 自分自身の値を変更するふるまいは持つべきではない
 */
data class BadUserName(
    // FIXME: 不変の方が良い
    private var name: String,
) {
    init {
        require(name.length >= 5) { "ユーザー名は5文字以上です" }
    }

    fun changeUserName(other: String) {
        this.name = other
    }
}