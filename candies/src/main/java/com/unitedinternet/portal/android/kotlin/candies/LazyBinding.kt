package com.unitedinternet.portal.android.kotlin.candies

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AttrRes
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

/*
 * Function to create a lazy variable without thread safety:
 *  Use it for things that you are 100% sure it will only be accessed by the main thread
 */
fun <T> lazyUnsync(init: () -> T): Lazy<T> = lazy (LazyThreadSafetyMode.NONE, init)

/*
 * Function find and bind a view lazily ot a variable in an activity
 */
fun <ViewT : View> Activity.lazyBindView(@IdRes idRes: Int, applyBlock: (ViewT.() -> Unit)? = null) = lazyUnsync {
    findViewById<ViewT>(idRes).apply { applyBlock?.invoke(this) }
}

/*
 * Function find and bind a view lazily ot a variable in a custom view
 */
fun <ViewT : View> View.lazyBindView(@IdRes idRes: Int, applyBlock: (ViewT.() -> Unit)? = null) = lazyUnsync {
    findViewById<ViewT>(idRes).apply { applyBlock?.invoke(this) }
}

/*
 * Function get a res value for strings, drawables, etc (used a lot in Compose module)
 */
fun Context.lazyResolveAttributeRes(@AttrRes attrRes: Int) = lazyUnsync {
    val typedValue = TypedValue()
    theme.resolveAttribute(attrRes, typedValue, true)
    typedValue.resourceId
}

/*
 * Function get a color attribute (used a lot in Compose module)
 */
fun Context.lazyResolveColorAttribute(@AttrRes attrRes: Int) = lazyUnsync {
    val typedValue = TypedValue()
    theme.resolveAttribute(attrRes, typedValue, true)
    typedValue.data
}
