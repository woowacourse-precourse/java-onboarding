package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {

            String num = String.valueOf(i);

            while(num.indexOf("3") != -1) {
                num = num.substring(0, num.indexOf("3")) + num.substring(num.indexOf("3") + 1, num.length());
                answer++;
            }
            while(num.indexOf("6") != -1) {
                num = num.substring(0, num.indexOf("6")) + num.substring(num.indexOf("6") + 1, num.length());
                answer++;
            }
            while(num.indexOf("9") != -1) {
                num = num.substring(0, num.indexOf("9")) + num.substring(num.indexOf("9") + 1, num.length());
                answer++;
            }

        }

        return answer;
    }
}
