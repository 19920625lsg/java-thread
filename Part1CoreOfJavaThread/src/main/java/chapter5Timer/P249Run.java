/***********************************************************
 * @Description : 线程执行时间过程，下次任务被延时
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 下午10:59
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter5Timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class P249Run {
    private static Timer timer = new Timer();

    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            try {
                System.out.println("begin 运行了！时间为：" + new Date());
                Thread.sleep(5000);
                System.out.println("  end 运行了！时间为：" + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        MyTask task = new MyTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2018-04-10 23:06:00";
        Date dateRef = sdf.parse(dateString);
        System.out.println("字符串时间为：" + dateRef.toLocaleString() + ", 当前时间为：" + new Date().toLocaleString());
        // 每4s执行一次
        timer.schedule(task, dateRef, 4000);
    }
}
