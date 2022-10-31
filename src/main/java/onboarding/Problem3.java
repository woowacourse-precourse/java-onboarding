package onboarding;

public class Problem3 {
    public static int countNum(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '3') {
                count++;
            }
            if (str.charAt(i) == '6') {
                count++;
            }
            if (str.charAt(i) == '9') {
                count++;
            }
        }
        return count;
    }
    public static int solution(int number) {

        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String str = i + "";
            answer = answer + countNum(str);
        }
        return answer;
    }
}
