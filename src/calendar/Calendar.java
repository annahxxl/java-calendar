package calendar;

public class Calendar {
	// 평년
	private final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	// 윤년
	private final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}

	}

	public void printCalendar(int year, int month, int weekday) {
		System.out.printf("       <  %d년 %d월  >\n\n", year, month);
		System.out.println(" SUN MON TUE WED THU FRI SAT");
		System.out.println("----------------------------");

		int maxDay = getMaxDaysOfMonth(year, month);

		// print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("    ");
		}

		// print first line
		int count = 7 - weekday;
		int delimit = count < 7 ? count : 0; // when you take a new line
		for (int i = 1; i <= count; i++) {
			System.out.printf("%4d", i);
		}
		System.out.println();

		// print from second line to last line
		count++;
		for (int i = count; i <= maxDay; i++) {
			System.out.printf("%4d", i);
			if (i % 7 == delimit) {
				System.out.println();
			}
		}

		System.out.println();
		System.out.println();
		System.out.println();

	}
}
