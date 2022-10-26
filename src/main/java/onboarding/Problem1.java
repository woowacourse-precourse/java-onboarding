package onboarding;

import java.util.List;

class Problem1 {

// 		기능요구사항
//
//		1. pobi의 왼쪽 숫자와 오른쪽 숫자를 가져온다.
// 		2. crong의 왼쪽 숫자와 오른쪽 숫자를 가져온다.
// 		3. calculate 로 각각왼쪽 숫자와 오른쪽 숫자의 각자리 숫자를 모두 더하거나, 모두 곱해서 큰수를 구한다.
//		4. 점수를 비교해 높은 사람이 승자가 된다.
// 		5. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다. => 왼쪽이 0 또는 399 오른쪽이 1 또는 400이 나오면 안된다.
//
// 		제한사항.
//
//		pobi와 crong의 길이는 2이다 => pobi.size(), crong.size() == 2이다
//		pobi와 crong에는 왼쪽 페이지 번호, 오른쪽 페이지 번호가 순서대로 들어있다.
// 		=> 오른쪽페이지 -1 = 왼쪽 페이지이다.

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = 0;

		if (pobi.size() !=2 || crong.size() != 2 ||pobi.get(1) - pobi.get(0) != 1
			|| crong.get(1) - crong.get(0) != 1 || pobi.get(0) == 0 || crong.get(0)== 0		// pobi와 crong의 길이는 2이다. 라는 제한사항
			|| pobi.get(1) == 1 || crong.get(1) == 1 || pobi.get(0) == 399					// pobi와 crong에는 왼쪽 페이지 번호, 오른쪽 페이지 번호가 순서대로 들어있다. 라는 제한사항
			|| crong.get(0)== 399 || pobi.get(1) == 400 || crong.get(1) == 400) {			// 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다 라는 기능 요구사항이 들어있는 if문입니다.
			return -1;																		// 예외 사항이므로 return -1
		}

		int pobimax = Math.max(calculate(pobi.get(0)), calculate(pobi.get(1)));
		int crongmax = Math.max(calculate(crong.get(0)), calculate(crong.get(1)));

		if (pobimax > crongmax) {					// pobi가 더 큰 경우이므로 1
			answer = 1;
		} else if (pobimax < crongmax) {			// crong이 더 큰 경우이므로 2
			answer = 2;
		} else
			answer = 0;								// 같은 경우 이므로 0

		return answer;
	}

	public static int calculate(int n) {
		int sum = 0;
		int mul = 1;
		while (n != 0) {                // ex) n = 97 => sum =7, mul = 7, n= 9
			sum += n % 10;				// ex) n이 9이므로 while(true) => sum = 9, mul = 9, n = 0
			mul *= n % 10;				// ex) sum = 16, mul = 63

			n /= 10;
		}

		return Math.max(sum, mul);		// ex) => Math.max(16,63)  ==> 63
	}

}