package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String srcStr = String.valueOf(i);
            String removed369Str = get369removedString(srcStr);
            answer += (srcStr.length() - removed369Str.length());
        }
        return answer;
    }

    private static String get369removedString(String numToString) {
        return numToString.replaceAll("3", "").replaceAll("6", "").replaceAll("9", "");
    }

}
