import android.view.View

private const val DEFAULT_THROTTLE_DELAY = 200L
fun View.setThrottledClickListener(
    delay: Long = DEFAULT_THROTTLE_DELAY,
    onClick: (View) -> Unit
) {
    setOnClickListener {
        throttle(delay) {
            onClick(it)
        }
    }
}

private var lastClickTimestamp = 0L
private fun throttle(
    delay: Long = DEFAULT_THROTTLE_DELAY,
    action: () -> Unit
): Boolean {
    val currentTimestamp = System.currentTimeMillis()
    val delta = currentTimestamp - lastClickTimestamp
    if (delta !in 0L..delay) {
        lastClickTimestamp = currentTimestamp
        action()
        return true
    }
    return false
}

inline fun View.showIf(condition: View.() -> Boolean) {
    if (condition()) {
        show()
    } else {
        hide()
    }
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}