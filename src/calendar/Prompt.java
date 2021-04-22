package calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "> ";

	public int parseDay(String strWeekday) {
		switch (strWeekday) {
		case "SUN":
			return 0;
		case "MON":
			return 1;
		case "TUE":
			return 2;
		case "WED":
			return 3;
		case "THU":
			return 4;
		case "FRI":
			return 5;
		case "SAT":
			return 6;
		}
		return 0; // default
	}

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar calendar = new Calendar();

		int year;
		int month;
		int weekday;

		while (true) {
			System.out.print("년도를 입력하세요 (종료:0)" + PROMPT);
			year = scanner.nextInt();
			if (year == 0) {
				System.out.println("👋 Bye Bye ~!");
				scanner.close();
				break;
			} else if (year < 0) {
				System.out.println("❌ 잘못된 값을 입력했습니다.");
				continue;
			}
			System.out.print("월을 입력하세요 " + PROMPT);
			month = scanner.nextInt();
			if (month < 1 || month > 13) {
				System.out.println("❌ 잘못된 값을 입력했습니다. 처음부터 다시 입력받습니다.");
				continue;
			}
			System.out.println("첫째 날의 요일을 입력하세요");
			System.out.println("[ SUN, MON, TUE, WED, THU, FRI, SAT ]");
			System.out.print("잘못된 값이 입력될 시 SUN 기준으로 출력됩니다 " + PROMPT);
			String strWeekday = scanner.next();
			weekday = parseDay(strWeekday);
			System.out.println();
			calendar.printCalendar(year, month, weekday);
		}
	}

	public static void main(String[] args) {

		Prompt prompt = new Prompt();
		prompt.runPrompt();

	}

}
