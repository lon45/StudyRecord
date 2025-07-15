package com.nader.commonutils.utils

import androidx.appcompat.app.AppCompatActivity
import com.nader.commonutils.test.MyUtils
import java.util.*

/**
 *Date: 2022/10/30
 *author: hxc
 */
class ActivityStack private constructor() {

    private var activityStack : Stack<AppCompatActivity>? = null

    companion object {
        private var mInstance:ActivityStack? = null
        fun getInstance():ActivityStack{
            if(mInstance == null){
                mInstance = ActivityStack()
            }
            return mInstance!!
        }

    }

    init {
        if (null == activityStack) {
            activityStack = Stack()
        }
    }

    /**
     * 添加Activity到堆栈
     */
    fun add(activity: AppCompatActivity?) {
        if (null != activity) {
            activityStack!!.add(activity)
        }
    }

    /**
     * 结束指定的Activity
     */
    fun remove(activity: AppCompatActivity?) {
        if (null != activity) {
            activityStack!!.remove(activity)
            activity.finish()
        }
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentActivity(): AppCompatActivity {
        return activityStack!!.lastElement()
    }

    /**
     * 得到指定类名的Activity
     */
    fun getActivity(cls: Class<*>): AppCompatActivity? {
        if (null == activityStack) {
            return null
        }
        for (activity in activityStack!!) {
            if (activity.javaClass == cls) {
                return activity
            }
        }
        return null
    }


    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        if (null == activityStack || activityStack!!.size == 0) {
            return
        }
        for (i in activityStack!!.indices.reversed()) {
            if (activityStack!![i].javaClass == cls) {
                remove(activityStack!![i])
            }
        }
    }

    /**
     * 结束最近的Activity
     */
    fun finishTopActivity() {
        if (null == activityStack || activityStack!!.size == 0) {
            return
        }
        val activity = activityStack!!.lastElement()
        remove(activity)
    }

    /**
     * 清除activity，只保留某个Acitivity
     */
    fun finishExceptActivity(cls: Class<*>) {
        if (null == activityStack || activityStack!!.size == 0) {
            return
        }
        for (i in activityStack!!.indices.reversed()) {
            val aClass: Class<out AppCompatActivity> = activityStack!![i].javaClass
            if (aClass != cls) {
                remove(activityStack!![i])
            }
        }
    }

    fun killActivity(activity: AppCompatActivity) {
        activity.finish()
        activityStack!!.remove(activity)
    }

    fun getCount(): Int {
        return if (activityStack == null) 0 else activityStack!!.size
    }

    operator fun contains(clazz: Class<out AppCompatActivity?>): Boolean {
        for (activity in activityStack!!) {
            if (activity.javaClass.name == clazz.name) {
                return true
            }
        }
        return false
    }

    //遍历栈中所有Activity，杀掉所有Activity
    fun clearAllActivity() {
        val n = activityStack!!.size
        for (i in 0 until n) {
            killActivity(activityStack!!.firstElement())
        }
    }

    fun test() {
        MyUtils.test()
    }

}