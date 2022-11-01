package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = game(number);
        return answer;
    }
    static private int game (int number){
        int answer = 0;
        String result = "";
        for (int i = 1; i <= number; i++) {
            result += Integer.toString(i);
        }
        int answer1 = result.length() - result.replace("3", "").length();
        int answer2 = result.length() - result.replace("6", "").length();
        int answer3 = result.length() - result.replace("9", "").length();
        answer = answer1+answer2+answer3;

        return answer;

    }
}
