package onboarding;

import java.util.Scanner;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;
		for (int i = 0; i <= number; i++) {
			int num = i;
			int count = 0;
			while (num != 0) {
				if ((num % 10) % 3 == 0) {
					if (num % 10 != 0) {
						count += 1;
					}
				}
				num = num / 10;
			}
			answer += count;
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