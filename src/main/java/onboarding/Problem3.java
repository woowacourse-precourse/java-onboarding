package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return getClapNumber(number);
    }

    public static int getClapNumber(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++ ){
            String str = Integer.toString(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '3') {
                    count += 1;
                }
                if (str.charAt(j) == '6') {
                    count += 1;
                }
                if (str.charAt(j) == '9') {
                    count += 1;
                }
            }
        }
        return count;
    }
}
