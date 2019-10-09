package com.unitedinternet.portal.android.kotlin.candies.app

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.unitedinternet.portal.android.kotlin.candies.*

private const val KEY_SHARED_PREF = "com.unitedinternet.portal.android.kotlin.candies.preferences"
private const val KEY_VALUE = "$KEY_SHARED_PREF.value"

class MainActivity : AppCompatActivity() {

    private val preferences by lazy { getSharedPreferences(KEY_SHARED_PREF, Context.MODE_PRIVATE) }

    private val titleTextChanged by lazyResolveAttributeRes(R.attr.titleTextChanged)
    private val titleColorChanged by lazyResolveColorAttribute(R.attr.titleColorChanged)

    private val titleTextView: TextView by lazyBindView(R.id.titleTextView)
    private val changeTitleButton: Button by lazyBindView(R.id.changeTitleButton)

    private val valueButton: Button by lazyBindView(R.id.valueButton)
    private val valueEditText: EditText by lazyBindView(R.id.valueEditText)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var value by IntPreference(
            preferences,
            KEY_VALUE,
            0
        )

        changeTitleButton.setOnClickListener {
            titleTextView.setText(titleTextChanged)
            titleTextView.setTextColor(titleColorChanged)
        }

        valueButton.setOnClickListener {
            value = valueEditText.text.toString().toInt()
            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
        }

        valueEditText.setText(value.toString())
    }
}
