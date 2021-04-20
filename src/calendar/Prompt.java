package calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "> ";

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar calendar = new Calendar();

		int year;
		int month;

		while (true) {
			System.out.print("년도를 입력하세요 (종료 : 0)" + PROMPT);
			year = scanner.nextInt();
			System.out.print("달을 입력하세요 (종료 : 0) " + PROMPT);
			month = scanner.nextInt();

			if (year == 0 || month == 0) {
				System.out.println("👋 Bye Bye ~!");
				scanner.close();
				break;
			} else if (year <= 0 || (month < 0 || month > 12)) {
				System.out.println("❌ 잘못된 달을 입력했습니다.");
				continue;
			}

			System.out.println();
			calendar.printCalendar(year, month);
		}
	}

	public static void main(String[] args) {

		Prompt prompt = new Prompt();
		prompt.runPrompt();

	}

}
