package onboarding;

public class Problem3 {
    public static boolean isOneTwoThree(int num) {
        String str = Integer.toString(num);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '3')
                return true;
            if (str.charAt(i) == '6')
                return true;
            if (str.charAt(i) == '9')
                return true;
        }
        return false;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
