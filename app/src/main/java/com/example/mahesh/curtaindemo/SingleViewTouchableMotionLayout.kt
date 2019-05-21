package com.example.mahesh.curtaindemo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.support.constraint.motion.MotionLayout
import android.support.constraint.motion.MotionScene
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlin.math.log

class SingleViewTouchableMotionLayout(context: Context, attributeSet: AttributeSet? = null) : MotionLayout(context, attributeSet) {

    private lateinit var viewToDetectTouch: View

    private val viewRect = Rect()

    private var touchStarted = false
    private var viewIdToDetectTouch = 0

    init {
        loadStyles(context, attributeSet!!)

        setTransitionListener(object : TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

            override fun allowsTransition(p0: MotionScene.Transition?): Boolean {
                return true
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                touchStarted = false
            }
        })
    }

    private fun loadStyles(context: Context, attributeSet: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.SingleViewTouchableMotionLayout)
        viewIdToDetectTouch = typedArray.getResourceId(R.styleable.SingleViewTouchableMotionLayout_viewToDetectTouch, 0)
        if (viewIdToDetectTouch == 0) {
            throw IllegalArgumentException("The handle attribute is required and must refer to a valid child.")
        }
        typedArray.recycle()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        viewToDetectTouch = findViewById<View>(viewIdToDetectTouch)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                touchStarted = false
                return super.onTouchEvent(event)
            }
        }
        if (!touchStarted) {
            viewToDetectTouch.getHitRect(viewRect)
            touchStarted = viewRect.contains(event.x.toInt(), event.y.toInt())
        }
        return touchStarted && super.onTouchEvent(event)
    }
}
