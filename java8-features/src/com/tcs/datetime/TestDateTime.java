package com.tcs.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestDateTime {
	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();
		LocalDate anotherDate = LocalDate.of(1998, 11, 24);
		LocalDate dateInString = LocalDate.parse("2010-10-25"); // yyyy-MM-dd
		System.out.println(currentDate);
		System.out.println(anotherDate);
		System.out.println(dateInString);
		LocalTime currentTime = LocalTime.now();
		LocalTime anotherTime = LocalTime.of(8, 20);
		LocalTime timeInString = LocalTime.parse("10:15:30");
		System.out.println(currentTime);
		System.out.println(anotherTime);
		System.out.println(timeInString);
		System.out.println("Year: "+currentDate.getYear()+", Month: "+currentDate.getMonthValue());
		System.out.println("---- passing date to the custom object ----");
		User user1 = new User("Bruce", LocalDate.parse("1990-08-22"));
		System.out.println("Hello "+user1.getName()+", your dob is on "+user1.getDob());
		// formatting the date in the way you want, you can use DateTimeFormatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(currentDate.format(formatter));
	}
}
