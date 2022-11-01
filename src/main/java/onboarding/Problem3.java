package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int current = i;
            int temp = answer;
            while (current != 0) {
                //current가 0이 아니고 입력된 숫자가 3, 6, 9가 있다면 카운트한다.
                if (current % 10 == 3 || current % 10 == 6 || current % 10 == 9){
                    answer++;
                }
                current /= 10;
            }

        }

        return answer;
    }
}