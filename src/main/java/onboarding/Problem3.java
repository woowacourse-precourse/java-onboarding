package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String strStore = "";

        for (int i = 1; i <= number; i++) {
            strStore = String.valueOf(i);

            for (int j = 0; j < strStore.length(); j++) {
                if (strStore.charAt(j) == '3' || strStore.charAt(j) == '6' ||
                        strStore.charAt(j) == '9') {
                    answer++;
                }
            }
        }

        return answer;
    }

}