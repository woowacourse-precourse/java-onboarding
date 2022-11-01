package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;
		answer = countClapping(number);
		return answer;
	}

	 /**
     * 박수를 센다.
     * @param 목표 숫자
     * @return 지금까지 친 박수 숫자
     */
	private static int countClapping(int number) {

		int clapping = 0;

		for (int num = 1; num <= number; num++) {
			clapping += countHas369(num);
		}

		return clapping;
	}
	
	 /**
     * 해당 숫자에 3.6.9가 몇개가 들어있는지 센다.
     * @param 대상 숫자
     * @return 3.6.9의 해당 갯수
     */
	private static int countHas369(int num) {

		int count369 = 0;
		String number = Integer.toString(num);

		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			count369 += is369(ch) ? 1 : 0;
		}

		return count369;
	}
	
	 /**
     * 해당 숫자가 3.6.9에 해당되는지 확인한다.
     * @param 대상 숫자
     * @return 해당여부
     */
	private static boolean is369(char charAt) {

		boolean is369 = false;
		char[] targetChar = { '3', '6', '9' };

		for (char ch : targetChar) {
			is369 = charAt == ch ? true : is369;
		}

		return is369;
	}
}
