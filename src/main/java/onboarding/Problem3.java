package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        String temp;
        for (int i = 1; i <= number; i++) {
            temp = Integer.toString(i);
            count += temp.length() - temp.replaceAll("[369]", "").length();
        }
        return count;
    }
}
