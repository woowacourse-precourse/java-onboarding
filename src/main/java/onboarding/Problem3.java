package onboarding;

public class Problem3 {

    private int checkThreeSixNine(int number) {

        String stringNumber = String.valueOf(number);
        int cnt = 0;

        for (char curChar : stringNumber.toCharArray()) {
            curChar = (char) (curChar - '0');
            if (curChar == 3 || curChar == 6 || curChar == 9) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int solution(int number) {

        Problem3 problem3 = new Problem3();
        int[] tSNArray = new int[10001];

        for (int i = 1; i <= 10000; i++) {
            tSNArray[i] = tSNArray[i - 1] + problem3.checkThreeSixNine(i);
        }

        return tSNArray[number];
    }
}
