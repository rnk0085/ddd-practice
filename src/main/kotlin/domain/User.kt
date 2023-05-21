package domain

/**
 * 条件がある場合はプリミティブ型を避けた方が良い
 */
data class User(
    val id: UserId,
    val name: UserName,
) {
    fun changeUserName(other: UserName) : User {
        return this.copy(name = other)
    }
}

/**
 * エンティティ
 *  ・属性を変化させたい場合は、ふるまいを通じて変更する
 *  ・必要に応じて属性を可変にすることを許可されている
 *
 *  TODO: エンティティは同一性で判断するはずなので、その部分は作らないといけなさそう…？
 */
data class UserEntity(
    val id: UserId,
    var name: UserName, // 可変
) {
    fun changeUserName(other: UserName) {
        this.name = other
    }
}


/**
 * 好ましくない。
 * ・プリミティブ型は検索をかけることが出来ない
 * ・条件が分からない（Intであれば何でも入ってしまう…）
 */
data class BeforeUser(
    val id: Int,
    val name: String,
)