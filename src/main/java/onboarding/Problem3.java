package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i<=number;i++){
            int flag = i;
            while (flag > 0) {
                int countNumber = flag % 10;
                if (countNumber == 3 || countNumber == 6 || countNumber == 9) {
                    answer++;
                }
                flag = flag/10;
            }
        }
        return answer;
    }
}
