package com.unitedinternet.portal.android.kotlin.candies

import android.content.SharedPreferences
import kotlin.reflect.KProperty

class BooleanPreference(
    private val sharedPreferences: SharedPreferences,
    private val key: String,
    private val defValue: Boolean) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Boolean {
        return sharedPreferences.getBoolean(key, defValue)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }
}

class IntPreference(
    private val sharedPreferences: SharedPreferences,
    private val key: String,
    private val defValue: Int) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return sharedPreferences.getInt(key, defValue)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }
}

class StringPreference(
    private val sharedPreferences: SharedPreferences,
    private val key: String,
    private val defValue: String) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return sharedPreferences.getString(key, defValue) ?: defValue
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }
}