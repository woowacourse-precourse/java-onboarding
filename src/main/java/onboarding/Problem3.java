package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 3; i <=number ; i++) {
            String temp = String.valueOf(i);
            answer += count(temp);
        }

        return answer;
    }

    static int count(String num) {
        int answer = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '3' || num.charAt(i) == '6' || num.charAt(i) == '9') {
                answer++;
            }
        }
        return answer;
    }
}
