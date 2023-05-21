package domain

/**
 * 条件がある場合はプリミティブ型を避けた方が良い
 */
data class User(
    val id: UserId,
    val name: UserName,
)

/**
 * 好ましくない。
 * ・プリミティブ型は検索をかけることが出来ない
 * ・条件が分からない（Intであれば何でも入ってしまう…）
 */
data class BeforeUser(
    val id: Int,
    val name: String,
)