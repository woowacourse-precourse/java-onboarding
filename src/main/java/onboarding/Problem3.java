package onboarding;

public class Problem3 {
    public static int countOneTwoThree(int num) {
        int cnt = 0;
        String str = Integer.toString(num);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '3')
                cnt++;
            if (str.charAt(i) == '6')
                cnt++;
            if (str.charAt(i) == '9')
                cnt++;
        }
        return cnt;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
