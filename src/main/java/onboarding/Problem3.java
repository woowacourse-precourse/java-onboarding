package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int num = 1; num <= number; num++) {
            String srcStr = String.valueOf(num);
            String removed369Str = get369removedString(srcStr);
            answer += (srcStr.length() - removed369Str.length());
        }
        return answer;
    }

    private static String get369removedString(String numToString) {
        return numToString.replaceAll("3", "")
                .replaceAll("6", "")
                .replaceAll("9", "");
    }
}
