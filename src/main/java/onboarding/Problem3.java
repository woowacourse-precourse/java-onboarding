package onboarding;

public class Problem3 {

    public static int solution(int number) {
        if (number < 3) {
            return 0;
        }

        int hap = 0;
        for (int i = 3; i <= number; i++) {
            hap += count(Integer.toString(i));
        }

        return hap;
    }

    public static int count(String number) {
        int hap = 0;
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch == '3' || ch == '6' || ch == '9') {
                hap += 1;
            }
        }
        return hap;
    }
}
