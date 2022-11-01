package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int cnt = 0;
        for (int i = 1; i < number + 1; i++){
            String str = Integer.toString(i);
            cnt += countChar(str, '3');
            cnt += countChar(str, '6');
            cnt += countChar(str, '9');
        }
        return cnt;
    }
    private static int countChar(String str, char ch) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                cnt++;
            }
        };
        return cnt;
    }
}
