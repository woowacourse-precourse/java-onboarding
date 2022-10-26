package onboarding;

public class Problem3 {
    static int answer = 0;
    public static int solution(int number) {
        return answer;
    }

    static void gameController(int number) {
        for (int i = 1; i <= number; i++) {

        }
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

    }

}
