package onboarding;

public class Problem3 {

    private static int getClapCount(int number){
        int result = 0;

        while (number != 0){
            // 3, 6, 9를 찾는다.
            if ((number % 10) % 3 == 0)
                if (number % 10 != 0)
                    result++;
            number /= 10;
        }
        return result;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int curr = 1; curr <= number; curr++){
            answer += getClapCount(curr);
        }

        return answer;
    }
}
