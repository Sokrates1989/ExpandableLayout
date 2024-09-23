package com.wisdom.felicitas.expandable.layout.uitest

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.wisdom.felicitas.expandable.layout.ExpandableLinearLayout
import kotlin.properties.Delegates

class ExpandableLinearLayoutActivity : AppCompatActivity() {

    private var expandableLayout: ExpandableLinearLayout by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_linear_layout)
        supportActionBar?.title = ExpandableLinearLayoutActivity::class.java.simpleName

        expandableLayout = findViewById(R.id.expandableLayout)
        findViewById<Button>(R.id.expandButton)?.setOnClickListener { expandableLayout.toggle() }
        findViewById<Button>(R.id.moveChildButton)?.setOnClickListener { expandableLayout.moveChild(1) }
        findViewById<Button>(R.id.moveChildButton2)?.setOnClickListener { expandableLayout.moveChild(2) }
        findViewById<Button>(R.id.moveTopButton)?.setOnClickListener { expandableLayout.move(0) }
        findViewById<Button>(R.id.setCloseHeightButton)?.setOnClickListener {
            expandableLayout.closePosition = expandableLayout.currentPosition
        }
    }
}