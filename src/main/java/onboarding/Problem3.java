package onboarding;

public class Problem3 {

    private static int countClaps(int num) {
        String numToStr = Integer.toString(num);
        String checkNum = "369";
        int claps = 0;

        for (int i = 0; i < numToStr.length(); i++) {
            if (checkNum.indexOf(numToStr.charAt(i)) != -1) {
                claps++;
            }
        }

        return claps;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int num = 0; num <= number; num++) {
            answer += countClaps(num);
        }

        return answer;
    }
}
