import domain.User
import domain.UserId
import domain.UserName

fun main() {
    val userId = UserId(0)
    val userName = UserName("rnk")

    val user = User(userId, userName)

    println(user)
}