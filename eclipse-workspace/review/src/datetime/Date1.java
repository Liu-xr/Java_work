package datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long justNow = System.currentTimeMillis();  // 返回UTC的毫秒数
        Date oldnow = new Date(justNow);
        // 时间形式：星期几英  月数英  日  hh：mm：ss CST（中央标准时间） YYYY
        System.out.println("5s前的时间为：" + oldnow);
        System.out.println("睡眠5秒后…………");
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        System.out.println("时间仍为刚才定格记录的时间：" + oldnow.toString() + "\n");

        Date now = new Date(System.currentTimeMillis()); // 直接传入避免时间差
        System.out.println("真正此时时间：" + now);
        // 也可以直接定格当前系统时间
        Date now1 = new Date();

        // 时间转字符串
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println("此时时间转为字符串：" + simpleDateFormat.format(now1));

        // 字符串转时间
        String time  = "2022年4月6日 11点10分";
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy年M月d日 hh点mm分");
        try {
            Date past = simpleDateFormat1.parse(time);
            System.out.println(past);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // 返回当前时间的毫秒数
        System.out.println(oldnow.getTime() == justNow);

	}

}
