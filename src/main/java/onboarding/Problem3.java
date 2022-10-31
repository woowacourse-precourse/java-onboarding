package onboarding;

public class Problem3 {
    static int clappingHands(int number) {

        int count = 0;

        while(number != 0) {
            int val = number % 10;
            if (val == 3 || val == 6 || val == 9) {
                count++;
            }
            number /= 10;
        }

        return count;
    }

    public static int solution(int number) {

        int answer = 0;
        for(int i = 1; i <= number; i++) {
            answer += clappingHands(i);
        }

        return answer;
    }
}
