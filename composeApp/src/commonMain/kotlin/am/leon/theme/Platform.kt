package am.leon.theme

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform