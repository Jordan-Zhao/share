package com.share.locker.common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhulin on 15/9/21.
 */
public class TimeUtil {
    /**
     * ���ص�ǰʱ������ʱ���ַ���
     *
     * @return
     */

    public static String getAfterTimeStr(int days) {
        int methodDays = 0;
        if (days < 0) {
            methodDays = Math.abs(days);
        } else {
            methodDays = days;
        }
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();//���Զ�ÿ��ʱ���򵥶��޸�
        calendar.setTime(now);
        //��ǰʱ�ڵ� ���Ƽ���
        calendar.add(Calendar.DAY_OF_MONTH, +methodDays);
        return calendar.get(Calendar.YEAR) + "" + (calendar.get(Calendar.MONTH) + 1)/*�·�0~11*/ + "" + calendar.get(Calendar.DATE);
    }

    /**
     * �õ�ǰdays���ʱ���ַ���
     *
     * @param days
     * @return
     */
    public static String getBeforDayTimeStr(int days) {
        int methodDays = 0;
        if (days > 0) {
            methodDays = -days;
        } else {
            methodDays = days;
        }
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();//���Զ�ÿ��ʱ���򵥶��޸�
        calendar.setTime(now);
        //��ǰʱ�ڵ� ��ǰ�Ƽ���
        calendar.add(Calendar.DAY_OF_MONTH, methodDays);
        return calendar.get(Calendar.YEAR) + "" + (calendar.get(Calendar.MONTH) + 1)/*�·�0~11*/ + "" + calendar.get(Calendar.DATE);
    }
}
