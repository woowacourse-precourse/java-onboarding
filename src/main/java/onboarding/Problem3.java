package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int countThreeSixNine(int n) {
        String n_str = String.valueOf(n);
        int cnt = 0;
        for (int i=0; i<n_str.length(); i++) {
            if (n_str.charAt(i) == '3' | n_str.charAt(i) == '6' | n_str.charAt(i) == '9') {
                cnt += 1;
            }
        }
        return cnt;
    }
}
