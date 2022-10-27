package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        answer = clapCount(number);
        return answer;
    }

    /**
     * 369 게임을 입력 된 수까지 진행할 때 총 박수 횟수 반환
     * @param number
     * @return int
     */
    public static int clapCount(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            int temp = i;
            while(temp != 0) {
                if((temp % 10 == 3) || (temp % 10 == 6) || (temp % 10 == 9)) count++;
                temp = temp /10;
            }
        }
        return count;
    }
}
