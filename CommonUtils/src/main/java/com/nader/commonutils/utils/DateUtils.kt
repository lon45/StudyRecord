package com.nader.commonutils.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

/**
 *Date: 2020/7/2
 *author: hxc
 * 计算星期
 */
@SuppressLint("SimpleDateFormat")
object DateUtils {
    val simpleDateFormat1 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val simpleDateFormat2 = SimpleDateFormat("yyyy/MM/dd")
    val simpleDateFormat3 = SimpleDateFormat("yyyy-MM-dd")
    val simpleDateFormat4 = SimpleDateFormat("yyyy.MM.dd")
    var simpleDateFormat6 = SimpleDateFormat("MM月dd日")
    val simpleDateFormat5 = SimpleDateFormat("HH:mm")
    var simpleDateFormat7 = SimpleDateFormat("HH:mm:ss")
    val simpleDateFormat8 = SimpleDateFormat("HH")
    var simpleDateFormat9 = SimpleDateFormat("MM月dd日 HH")
    var simpleDateFormat10 = SimpleDateFormat("EEEE")

    fun getWeekName(): String {
        val cal = Calendar.getInstance()
        val dayOfWeek = cal[Calendar.DAY_OF_WEEK] - 1
        var weekName = ""
        when (dayOfWeek) {
            0 -> weekName = "星期日"
            1 -> weekName = "星期一"
            2 -> weekName = "星期二"
            3 -> weekName = "星期三"
            4 -> weekName = "星期四"
            5 -> weekName = "星期五"
            6 -> weekName = "星期六"
        }
        return weekName
    }
    fun getWeekName2(): String {
        val cal = Calendar.getInstance()
        val dayOfWeek = cal[Calendar.DAY_OF_WEEK] - 1
        var weekName = ""
        when (dayOfWeek) {
            0 -> weekName = "周日"
            1 -> weekName = "周一"
            2 -> weekName = "周二"
            3 -> weekName = "周三"
            4 -> weekName = "周四"
            5 -> weekName = "周五"
            6 -> weekName = "周六"
        }
        return weekName
    }

    private fun getWeekNameByDate(dateStr:String): String {
        if(dateStr.isNotEmpty()) {
            val date =  simpleDateFormat3.parse(dateStr)
            return simpleDateFormat10.format(date)
        }
        val cal = Calendar.getInstance()
        val dayOfWeek = cal[Calendar.DAY_OF_WEEK] - 1
        var weekName = ""
        when (dayOfWeek) {
            0 -> weekName = "周日"
            1 -> weekName = "周一"
            2 -> weekName = "周二"
            3 -> weekName = "周三"
            4 -> weekName = "周四"
            5 -> weekName = "周五"
            6 -> weekName = "周六"
        }
        return weekName
    }

    /**
     * 获取前n天的0点时间
     */
    fun getTime(offset:Int):Long{
        var calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE,offset)
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.timeInMillis
    }

    fun getDateByTime(time:Long):String{
        val date = Date(time)
        return simpleDateFormat3.format(date)
    }
}