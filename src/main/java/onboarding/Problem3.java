package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int hap = 0;
        if (number < 3)
            return 0;
        for (int i = 3; i <= number; i++) {
            String temp = Integer.toString(i);
            for (int j = 0; j < temp.length(); j++) {
                char ch = temp.charAt(j);
                if (ch == '3' || ch == '6' || ch == '9')
                    hap += 1;
            }
        }
        return hap;
    }
}
