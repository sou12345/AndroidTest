package com.test.roomwithmvvmdagger

import android.app.Activity
import android.util.Patterns
import android.view.Window
import android.view.WindowManager
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar


fun Activity.changeStatusColor(color: Int) {
    val window: Window = this.window
    // clear FLAG_TRANSLUCENT_STATUS flag:
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    // finally change the color
    window.statusBarColor = ContextCompat.getColor(this, color)
    window.navigationBarColor = ContextCompat.getColor(this, color)
}

fun snackBar(msg: String, actionButtonName: String, constraintLayout: ConstraintLayout) {
    val snackbar: Snackbar = Snackbar
        .make(constraintLayout, msg, Snackbar.LENGTH_LONG)
        .setAction(actionButtonName) {
            val snackbar1 = Snackbar.make(constraintLayout, "", Snackbar.LENGTH_SHORT)
            snackbar1.show()
        }
    snackbar.show()
}

fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()



