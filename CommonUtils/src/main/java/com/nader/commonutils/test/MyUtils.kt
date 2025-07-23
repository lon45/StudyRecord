package com.nader.commonutils.test

import android.util.Log
import com.nader.commonutils.utils.ActivityStack
import com.nader.commonutils.utils.DateUtils

/**
 *Date: 2025/7/14
 *author: hxc
 */
object MyUtils {

    fun test() {
        Log.i("MyUtils","${ActivityStack.getInstance().currentActivity()}")
        Log.i("MyUtils","${DateUtils.getWeekName()}")
        ActivityStack.getInstance().currentActivity().run {
            Log.i("MyUtils","${ActivityStack.getInstance().getCount()}")
            Log.i("MyUtils","1111111111111111111111")
        }
    }

}