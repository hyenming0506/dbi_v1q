package web.calender;

import java.util.Calendar;

public class myCal {
	int year;
	int mon;
	int day;
	int hour;
	Calendar cal = Calendar.getInstance(); // new Calendar 와 비슷한거
	String[] monthName = {  "January", "February", "March", "April", "May",
			"June", "July", "August", " September", "October", "November",
			"December"
			};
	
	String[] DayName = {
		"SUNDAY" , "MONDAY","TUESDAY", "WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"
	};
	
	public String[] getDayName() {
		return DayName;
	}
	public void setDayName(String[] dayName) {
		DayName = dayName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMon() {
		return mon;
	}
	public void setMon(int mon) {
		this.mon = mon;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public Calendar getCal() {
		return cal;
	}
	public void setCal(Calendar cal) {
		this.cal = cal;
	}
	public String[] getMonthName() {
		return monthName;
	}
	public void setMonthName(String[] monthName) {
		this.monthName = monthName;
	}
	
	public myCal(){ // 생성자
		
		this.year= cal.get(Calendar.YEAR);
		this.mon= cal.get(Calendar.MONTH)+1;
		this.day = cal.get(Calendar.DAY_OF_MONTH);
		this.year = cal.get(Calendar.HOUR);
		
	}
}
