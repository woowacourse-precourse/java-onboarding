package onboarding;

/** TODO
 * 1. 해당 숫자까지 반복
 * 2. 각 숫자마다 3,6,9 포함 갯수 세기
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 0; i <= number; i++) {
            String currentNumber = String.valueOf(i);

            for (int j = 0; j < currentNumber.length(); j++) {
                if (currentNumber.charAt(j) == '3' || currentNumber.charAt(j) == '6' || currentNumber.charAt(j) == '9') {
                    answer++;
                }
            }
        }
        return answer;
    }
}
