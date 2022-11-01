package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String strOfi = String.valueOf(i);      // 369 333
            for (int j = 0; j < strOfi.length(); j++) {
                if (strOfi.charAt(j) == '3' || strOfi.charAt(j) == '6' || strOfi.charAt(j) == '9') {
                    answer++;
                }
            }
        }
        return answer;
    }
}
