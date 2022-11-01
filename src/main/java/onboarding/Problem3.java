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

    // num까지 손치는 횟수 반환
    public static int countHitPalm(int num) {
        int cnt = 0;
        for (int i = 1; i < num  + 1; i++) {
            cnt += countOneTwoThree(i);
        }
        return cnt;
    }

    public static int solution(int number) {
        int answer = countHitPalm(number);
        return answer;
    }
}
