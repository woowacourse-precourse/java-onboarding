package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

		// 5만원 부터 갯수 기입 위한 변수 && 다음 단위 화폐로 나누기 위한 변수
		int sinsa = 50000;
		int target = 0;

		for (int i = 0; i < 9; i++) {
			// 화폐별 갯수 기입
			answer.add(i, money / sinsa);
			money %= sinsa;

			if (target == 0) {
				target = 1;
				sinsa /= 5; // 5로 시작하는 돈 1로
			} else if (money != 0 && money < 10) {
				sinsa /= 10; // 1의 자리
			} else {
				target = 0;
				sinsa /= 2; // 1로 시작하는 돈 5로
			}
		}

        return answer;
    }

//	public static void main(String[] args) {
//		List<Integer> answer = new ArrayList<>();
////		answer.add(0);
////		answer.add(0);
////		answer.add(0);
////		answer.add(0);
////		answer.add(0);
////		answer.add(0);
////		answer.add(0);
////		answer.add(0);
////		answer.add(0);
////		System.out.println(answer);
//
////		int money = 243787;
//		// [4, 4, 0, 3, 1, 2, 1, 3, 7]
////		String str = Integer.toString(money);
////		System.out.println(str.charAt(2)); // char
////		int in = str.charAt(2) - '0';
////		System.out.println(str.charAt(2) - '0'); // int
////		System.out.println(str);
//
////		answer.set(answer.size() - 1, money % 10);
////		System.out.println(answer);
////		while (money > 0) {
////			for (int i = str.length() - 2; i >= 0; i--) {
////				if (str.charAt(i) - '0' >= 5) {
////					cnt++;
////					answer.set(answer.size() - i + 1, cnt);
////					answer.set(answer.size() - i + 2, str.charAt(i) - '5');
////				} else {
////					answer.set(answer.size() - i + 2, str.charAt(i) - '0');
////				}
////				cnt = 0;
////			}
////			money /= 10;
////		}
//
//
////		for (int i = 1; i < str.length(); i++) {
////			int cnt = 0;
////			if (str.charAt(str.length() - 1 - i) - '0' >= 5) {
////				cnt++;
////				answer.set(answer.size() - (i * 2 + 1), cnt);
////				answer.set(answer.size() - i * 2, str.charAt(str.length() - 1 - i) - '5');
////			} else {
////				answer.set(answer.size() - i - 1, str.charAt(str.length() - 1 - i) - '0');
////			}
////		}
////		int money = 243787;
////		answer.clear();
//		/*
//		1의 자리는 그대로
//		10의 자리는 10으로 나눈 나머지
//		 */
//		int money = 15000;
//		int sinsa = 50000;
//		int target = 0;
//
//		for (int i = 0; i < 9; i++) {
//			// idx 에 금액 입력
//			answer.add(i, money / sinsa);
//			money %= sinsa;
//
//			if (target == 0) {
//				target = 1;
//				sinsa /= 5;
//			} else if (money < 10 && money != 0) {
//				sinsa /= 10;
//			} else {
//				target = 0;
//				sinsa /= 2;
//			}
//
//		}
//
//		System.out.println(answer);
//
//	}
}
