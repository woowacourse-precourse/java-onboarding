package onboarding;

public class Problem3 {
    public static int solution(int number) {
        String sTemp;
        int count = 0;
        for (int i = 1; i <= number; i += 1) {
            sTemp = i + "";
            for (int j = 0; j < sTemp.length(); j += 1) {
                if (sTemp.charAt(j) == '3' || sTemp.charAt(j) == '6' || sTemp.charAt(j) == '9') {
                    count += 1;
                }
            }
        }
        return count;
    }
}