package onboarding;

import java.util.Scanner;

public class Problem3 {
	public static int sub(int number) {
		int answer = 0;
		while (number != 0) {
			if ((number % 10) % 3 == 0) {
				if (number % 10 != 0) {
					answer += 1;
				}
			}
			number = number / 10;
		}
		return answer;
	}

	public static int solution(int number) {
		int answer = 0;
		int num;
		for (int i = 0; i <= number; i++) {
			num = sub(i);
			answer += num;
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close();
		System.out.println(solution(number));
	}
}
