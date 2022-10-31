package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String str = String.valueOf(i);
            if (is369Contained(str)) {
                // 369 포함되어 있으면 개수 세서 answer에 추가
            }
        }

        return answer;
    }

    public static boolean is369Contained(String str) {
        return str.contains("3") || str.contains("6") || str.contains("9");
    }
}
