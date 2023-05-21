package domain

/**
 * ルールが存在している
 * UserName は「5文字以上」であることが保証される
 */
@JvmInline
value class UserName(
    private val name: String,
) {
    init {
        require(name.length >= 5) { "ユーザー名は5文字以上です" }
    }
}