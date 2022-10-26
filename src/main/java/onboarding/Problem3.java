package onboarding;

public class Problem3 {
    static int answer = 0;
    public static int solution(int number) {
        gameController(number);
        return answer;
    }

    static int gameController(int number) {
        for (int i = 1; i <= number; i++) {
            answer += checkNumber(i);
        }

        return answer;
    }

    static int checkNumber(int number) {
        String target = "369";
        String[] numberArr = Integer.toString(number).split("");
        int result = 0;

        for(String num : numberArr) {
            if (target.contains(num)) {
                result += 1;
            }
        }

        return result;
    }
}
