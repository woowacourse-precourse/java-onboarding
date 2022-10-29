package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i=1;i<=number;i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(i));

            for (int j=0;j<sb.length();j++) {
                if (sb.charAt(j) -'0' != 0 && (sb.charAt(j) -'0') % 3 == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}