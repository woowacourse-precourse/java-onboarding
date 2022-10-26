package onboarding;

public class Problem3 {
    /***
     *
     * 기능1. 1 ~ number까지의 수 나열을 문자열로 만드는 기능 -> numberSequenceToString()
     * 기능2. 기능2의 합을 구하는 기능 -> getClapCount()
     *
     * 기능2 구현을 위한 함수 - 문자열에서 특정 문자의 횟수를 세는 함수 -> count()
     */

    public static int solution(int number) {
        int answer = 0;
        String routine = "";

        routine = numberSequenceToString(number);
        answer = getClapCount(routine);

        return answer;
    }

    // 기능 1
    public static String numberSequenceToString(int number) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= number; i++)  sb.append(i);

        return sb.toString();
    }

    // 기능 2
    public static int getClapCount(String routine) {
        return count(routine, '3') + count(routine, '6') + count(routine, '9');
    }

    public static int count (String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }
}
