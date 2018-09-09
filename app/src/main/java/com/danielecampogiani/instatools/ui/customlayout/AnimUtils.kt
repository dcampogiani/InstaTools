/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.danielecampogiani.instatools.ui.customlayout

import android.animation.Animator
import android.animation.TimeInterpolator
import android.content.Context
import android.os.Build
import android.util.ArrayMap
import android.util.FloatProperty
import android.util.IntProperty
import android.util.Property
import android.view.animation.AnimationUtils
import android.view.animation.Interpolator
import android.view.animation.LinearInterpolator

import java.util.ArrayList

/**
 * Utility methods for working with animations.
 */
object AnimUtils {

    private var fastOutSlowIn: Interpolator? = null
    private var fastOutLinearIn: Interpolator? = null
    private var linearOutSlowIn: Interpolator? = null

    fun getFastOutSlowInInterpolator(context: Context): Interpolator {

        return fastOutSlowIn?.let {
            it
        } ?: AnimationUtils.loadInterpolator(context, android.R.interpolator.fast_out_slow_in).also {
            fastOutSlowIn = it
        }
    }

    /**
     * A delegate for creating a [Property] of `int` type.
     */
    abstract class IntProp<T>(val name: String) {

        abstract operator fun set(`object`: T, value: Int)
        abstract operator fun get(`object`: T): Int
    }

    /**
     * The animation framework has an optimization for `Properties` of type
     * `int` but it was only made public in API24, so wrap the impl in our own type
     * and conditionally create the appropriate type, delegating the implementation.
     */
    fun <T> createIntProperty(impl: IntProp<T>): Property<T, Int> {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            object : IntProperty<T>(impl.name) {
                override fun get(`object`: T): Int? {
                    return impl[`object`]
                }

                override fun setValue(`object`: T, value: Int) {
                    impl[`object`] = value
                }
            }
        } else {
            object : Property<T, Int>(Int::class.java, impl.name) {
                override fun get(`object`: T): Int? {
                    return impl[`object`]
                }

                override fun set(`object`: T, value: Int?) {
                    impl[`object`] = value!!
                }
            }
        }
    }

    /**
     * A delegate for creating a [Property] of `float` type.
     */
    abstract class FloatProp<T> protected constructor(val name: String) {

        abstract operator fun set(`object`: T, value: Float)
        abstract operator fun get(`object`: T): Float
    }

    private class AnimatorListenerWrapper internal constructor(private val mAnimator: Animator, private val mListener: Animator.AnimatorListener) : Animator.AnimatorListener {

        override fun onAnimationStart(animator: Animator) {
            mListener.onAnimationStart(mAnimator)
        }

        override fun onAnimationEnd(animator: Animator) {
            mListener.onAnimationEnd(mAnimator)
        }

        override fun onAnimationCancel(animator: Animator) {
            mListener.onAnimationCancel(mAnimator)
        }

        override fun onAnimationRepeat(animator: Animator) {
            mListener.onAnimationRepeat(mAnimator)
        }
    }
}