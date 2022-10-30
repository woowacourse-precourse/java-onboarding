package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += getClaps(i);
        }

        return answer;
    }

    private static int getClaps(int nowNumber) {
        String strNumber = String.valueOf(nowNumber);
        String removed = removeClaps(strNumber);

        return strNumber.length() - removed.length();
    }

    private static String removeClaps(String strNum) {
        strNum = strNum.replace("3", "");
        strNum = strNum.replace("6", "");
        strNum = strNum.replace("9", "");

        return strNum;
    }
}
