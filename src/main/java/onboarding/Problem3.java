package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        answer = clapCount(number);
        return answer;
    }

    /**
     * 369 게임을 입력 된 수까지 진행할 때 총 박수 횟수 반환
     * @param {int} number
     * @return {int} count
     */
    public static int clapCount(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            int currentNumber = i;
            while(currentNumber != 0) {
                if((currentNumber % 10 == 3) || (currentNumber % 10 == 6) || (currentNumber % 10 == 9)) count++;
                currentNumber = currentNumber /10;
            }
        }
        return count;
    }
}
