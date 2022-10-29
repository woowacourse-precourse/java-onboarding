package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1;i<=number;i++) {
            int a = i;
            while (a > 0) {
                if (check(a))
                    answer++;
                a/=10;
            }
        }

        return answer;
    }
    public static Boolean check(int num) {
        switch (num%10) {
            case 3:
            case 6:
            case 9:
                return true;
            default:
                return false;
        }
    }
}
