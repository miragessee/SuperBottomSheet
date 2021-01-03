package com.andrefrsousa.superbottomsheet.demo

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.andrefrsousa.superbottomsheet.CornerRadiusFrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_demo_persistent.*

class DemoPersistentActivity : AppCompatActivity() {

    //#1 Defining a BottomSheetBehavior instance
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<CornerRadiusFrameLayout>

    internal lateinit var sheetContainer: CornerRadiusFrameLayout

    internal lateinit var textView4: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_persistent)

        sheetContainer = findViewById(R.id.super_bottom_sheet)!!
        sheetContainer.setCornerRadius(64f)

        //#2 Initializing the BottomSheetBehavior
        bottomSheetBehavior = BottomSheetBehavior.from(sheetContainer)



        //#3 Listening to State Changes of BottomSheet
        bottomSheetBehavior.addBottomSheetCallback(object :
                BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                buttonBottomSheetPersistent.text = when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> "Close Persistent Bottom Sheet"
                    BottomSheetBehavior.STATE_HIDDEN -> "Open Persistent Bottom Sheet"
                    else -> "Persistent Bottom Sheet"
                }
            }
        })


        //#4 Changing the BottomSheet State on ButtonClick
        buttonBottomSheetPersistent.setOnClickListener {
            val state =
                    if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                        BottomSheetBehavior.STATE_HIDDEN
                    else
                        BottomSheetBehavior.STATE_EXPANDED
            bottomSheetBehavior.state = state
        }

        textView4 = findViewById(R.id.textView4)!!

        textView4.setOnClickListener {
            System.out.println("textview4 click")
        }
    }
}