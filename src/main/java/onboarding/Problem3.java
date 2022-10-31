package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += is_crap(i);
        }
        return answer;
    }

    public static int is_crap(int n) {
        int result = 0;
        String tmp = Integer.toString(n);
        for (int i = 0; i < tmp.length(); i++) {
            if ((tmp.split("")[i]).equals("3") || (tmp.split("")[i]).equals("9") || (tmp.split("")[i]).equals("6")) {
                result++;
            }
        }
        return result;
    }
}
