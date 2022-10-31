package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int n = 1; n <= number; n++){
            answer += count(n);
        }

        return answer;
    }

    private static int count(int num){
        int result = 0;
        while (num > 0){
            int current = num % 10;

            if (current == 3 || current == 6 || current == 9){
                result += 1;
            }
            num /= 10;
        }
        return result;
    }
}