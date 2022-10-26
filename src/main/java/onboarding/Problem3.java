package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        return gameController(number, answer);
    }

    static int gameController(int number, int answer) {
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

    public static void main(String[] args) {
        System.out.println(solution(33));
    }
}
