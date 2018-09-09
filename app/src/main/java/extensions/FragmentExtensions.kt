package extensions

import android.content.Context
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager

fun Fragment.dismissKeyboard() {
    val imm: InputMethodManager? = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    activity?.currentFocus?.windowToken?.let {
        imm?.hideSoftInputFromWindow(it, 0)
    }
}