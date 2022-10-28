package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String check = "";
        char numCheck = ' ';

        for (int i = 1; i <= number; i++) {
            check = ""+i;
            for (int j = 0; j < check.length(); j++) {
                numCheck = check.charAt(j);
                System.out.println("numCheck = " + numCheck);
                if (numCheck == '3' || numCheck == '6' || numCheck == '9') {
                    answer++;
                }
            }
        }
        System.out.println("answer = " + answer);

        return answer;
    }
}
