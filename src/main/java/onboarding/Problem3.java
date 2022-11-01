package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = count369(number);
        return answer;
    }

    public static int count369(int number) {
        int countFreq369 = 0;
        for (int i = number; i > 0; i--) {
            number = i;
            while (number > 0) {
                if ((number % 10) == 3 || (number % 10) == 6 || (number % 10) == 9) {
                    countFreq369 += 1;
                }
                number /= 10;
            }
        }
        return countFreq369;
    }
}
