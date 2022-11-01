package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        String routine = "";

        routine = numberSequenceToString(number);
        answer = getClapCount(routine);

        return answer;
    }

    public static String numberSequenceToString(int number) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= number; i++)  sb.append(i);

        return sb.toString();
    }

    public static int getClapCount(String routine) {
        return count(routine, '3') + count(routine, '6') + count(routine, '9');
    }

    public static int count (String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

}
