package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return gameController(number);
    }

    static int gameController(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += checkNumber(i);
        }

        return answer;
    }

    static int checkNumber(int number) {
        String[] numberArr = Integer.toString(number).split("");
        String target = "369";
        int result = 0;

        for(String num : numberArr) {
            if (target.contains(num)) {
                result += 1;
            }
        }

        return result;
    }
}
