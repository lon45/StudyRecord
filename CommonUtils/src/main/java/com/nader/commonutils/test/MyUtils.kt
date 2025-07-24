package com.nader.commonutils.test

import android.util.Log
import com.nader.commonutils.utils.ActivityStack
import com.nader.commonutils.utils.DateUtils
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 *Date: 2025/7/14
 *author: hxc
 */
object MyUtils {

    fun test() {
        Log.i("MyUtils","${DateUtils.getWeekName()}")
    }

    private val location_rule = "^[\\u4e00-\\u9fffA-Z]{1,5}[\\u4e00-\\u9fffA-Z0-9]\$"
    private val name_rule = "^[\\u4e00-\\u9fffA-Z]{1,9}[\\u4e00-\\u9fffA-Z0-9]\$"
    fun matchName(name: String): Boolean {
        return try {
            val pattern = Pattern.compile(name_rule)
            val matcher = pattern.matcher(name)
            matcher.matches()
        } catch (e: Exception) {
            false
        }
    }

    fun matchLocation(location: String): Boolean {
        return try {
            val pattern = Pattern.compile(location_rule)
            val matcher = pattern.matcher(location)
            matcher.matches()
        } catch (e: Exception) {
            false
        }
    }

}