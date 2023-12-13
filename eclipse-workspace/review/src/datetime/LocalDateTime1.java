package datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTime1 {
	public static void main(String[] args) {
			// 日期类型
		 	LocalDate today = LocalDate.now();
	        System.out.println("直接输出日期类型" + today); // YYYY-MM-dd
	        // 返回日期的年月日int类型
	        int year = today.getYear();
	        int month = today.getMonthValue();;
	        int day = today.getDayOfMonth();
	        System.out.println(year);
	        System.out.println(month);
	        System.out.println(day);

	        // 自定义传入日期
	        LocalDate dateOfBirthday = LocalDate.of(2002, 04, 06);
	        System.out.println("直接输出日期类型" + dateOfBirthday);
	        
	        // 月日类型，自定义传入
	        MonthDay birthday = MonthDay.of(4, 6);
	        System.out.println("生日：" + birthday);  // -- 04-06
	        // 将日期类型调整取为月日类型
	        MonthDay now = MonthDay.from(today);
	        System.out.println(now);
	        //年月类型
	        YearMonth ym = YearMonth.now();
	        System.out.println("年月类型输出：" + ym);
	        
	        // 日期的加减
	        LocalDate newDate = today.plus(1, ChronoUnit.YEARS); // 加1年
	        System.out.println("一年后" + newDate);
	        System.out.println("十年前" + today.minus(1, ChronoUnit.DECADES));  // 加1个十年
	        System.out.println(today.isAfter(newDate));   // 比较时间前后，today是否晚于newDate
	        
	        System.out.println("是否为闰年：" + today.isLeapYear());
	        
	        //时间类型
	        LocalTime time = LocalTime.now();
	        System.out.println(time);
	        System.out.println(time.getSecond());
	        System.out.println(time.getNano());      
	                    
	        // 时间段类型
	        Period p = Period.between(LocalDate.of(1900, 01, 01), today);
	        System.out.println("输出时间段类型：" + p);
	        System.out.println(p.getMonths());
	        
	        // 时间戳类型
	        Instant i = Instant.now();
	        System.out.println("输出时间戳类型：" + i);
	        System.out.println(i.getEpochSecond());
	        
	        // 日期时间类型
	        LocalDateTime dateTime = LocalDateTime.now();
	        System.out.println("这一年的第" + dateTime.getDayOfYear() + "天");
	        
	        
	        /*字符串日期互转*/
	        //日期时间转字符串
	        LocalDateTime date = LocalDateTime.now();
	        //日期显示yyyy-mm-dd，自定义转换的字符串格式
	        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	        String str = date.format(format1);
	        System.out.println("日期时间转换为字符串:"+str);
	        //字符串转日期
	        String str2 = "2022年04月13日";
	        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
	        LocalDate date2 = LocalDate.parse(str2, format2);
	        System.out.println("字符串转日期类型:" + date2);
	        //转时间
	        String str3 = "11时10分46秒";
	        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("HH时mm分ss秒");
	        LocalTime time1 = LocalTime.parse(str3, format3);
	        System.out.println("字符串转时间类型:" + time1);

	}

}
