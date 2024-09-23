package com.wisdom.felicitas.expandable.layout.uitest

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.wisdom.felicitas.expandable.layout.ExpandableLinearLayout
import io.reactivex.disposables.CompositeDisposable
import kotlin.properties.Delegates

/**
 * test for [com.wisdom.felicitas.expandable.layout.ExpandableLinearLayout#initlayout]
 *
 * The default value is  {@link android.view.animation.AccelerateDecelerateInterpolator}
 *
 */
class ExpandableLinearLayoutActivity3 : AppCompatActivity() {

    private var expandableLayout: ExpandableLinearLayout by Delegates.notNull()
    private val subscriptions: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_linear_layout3)
        supportActionBar?.title = ExpandableLinearLayoutActivity::class.java.simpleName

        expandableLayout = findViewById(R.id.expandableLayout) as ExpandableLinearLayout
        findViewById<Button>(R.id.expandButton)?.setOnClickListener { expandableLayout.toggle() }
        findViewById<Button>(R.id.moveChildButton)?.setOnClickListener { expandableLayout.moveChild(0) }
        findViewById<Button>(R.id.moveChildButton2)?.setOnClickListener { expandableLayout.moveChild(1) }

        // uncomment if you want to check the #ExpandableLayout.initLayout()
//        val child1 = findViewById(R.id.child1) as TextView
//        subscriptions.add(Observable.timer(5, TimeUnit.SECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe {
//                    child1.text =
//                            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//                    expandableLayout.initLayout()
//                    expandableLayout.expand(0, null)
//                })
    }

    override fun onDestroy() {
        subscriptions.dispose()
        super.onDestroy()
    }
}