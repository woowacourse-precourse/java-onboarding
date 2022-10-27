package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        while (number > 0) {
            int countNumber = number % 10;
            if (countNumber == 3 || countNumber == 6 || countNumber == 9) {
                answer++;
            }
            number /= 10;
        }
        
        return answer;
    }
}
