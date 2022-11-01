package onboarding;

import java.util.*;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if(!(validateList(pobi) && validateList(crong))) return -1;

		return getWinner(convertCalculatedList(pobi), convertCalculatedList(crong));
	}


	/**
	 * 주어진 list에 대한 유효성 검사를 실시
	 * @param list
	 * @return
	 */
	public static boolean validateList(List<Integer> list) {
		if(list.contains(1) || list.contains(400)) return false;
		if(list.size() != 2) return false;
		if((list.get(1) - list.get(0)) != 1) return false;
		if(list.get(0) % 2 != 1) return false;
		if(list.get(1) % 2 != 0) return false;

		return true;
	}


	/**
	 * 주어진 수의 각 자리 숫자를 모두 더한 값을 반환
	 * @param number
	 * @return
	 */
	public static int calculateSumOfDigits(int number){
		int sum = 0;

		while(number >= 10) {
			int ondDigit = number % 10;
			sum += ondDigit;
			number /= 10;
		}

		sum += number;

		return sum;
	}

	/**
	 * 주어진 수의 각 자리 숫자를 모두 곱한 값을 반환
	 * @param number
	 * @return
	 */
	public static int calculateMulOfDigits(int number){
		int mul = 1;

		while(number >= 10) {
			int ondDigit = number % 10;
			mul *= ondDigit;
			number /= 10;
		}

		mul *= number;

		return mul;
	}

	/**
	 * 주어진 정수형 리스트를 계산(합/곱)한 숫자 리스트로 변환
	 * @param originalList
	 * @return
	 */
	public static List<Integer> convertCalculatedList(List<Integer> originalList) {
		List<Integer> calculatedList = new ArrayList<>();

		for(Integer number : originalList) {
			calculatedList.add(calculateSumOfDigits(number));
			calculatedList.add(calculateMulOfDigits(number));
		}

		return calculatedList;
	}

	/**
	 * 주어진 정수형 리스트에서 가장 큰 값을 반환
	 * @param list
	 * @return
	 */
	public static int getMaxNumber(List<Integer> list) {
		return Collections.max(list);
	}

	/**
	 * 점수를 비교하여 게임의 승자를 판단하여 반환한다.
	 *
	 * @param calculatedListOfPobi 포비의 계산된 리스트
	 * @param calculatedListOfCrong 크롱의 계산된 리스트
	 * @return 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0
	 */
	public static int getWinner(List<Integer> calculatedListOfPobi, List<Integer> calculatedListOfCrong) {
		int maxNumberOfPobi = getMaxNumber(calculatedListOfPobi);
		int maxNumberOfCrong = getMaxNumber(calculatedListOfCrong);
		
		if(maxNumberOfPobi > maxNumberOfCrong) return 1;
		if(maxNumberOfPobi < maxNumberOfCrong) return 2;
		if(maxNumberOfPobi == maxNumberOfCrong) return 0;
		return -1;
	}
}