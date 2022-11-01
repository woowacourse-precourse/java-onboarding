package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String tmp = String.valueOf(i);
            for (int j = 0; j < tmp.length(); j++) {
                char chartmp = tmp.charAt(j);
                if (chartmp == '3' || chartmp == '6' || chartmp == '9') {
                    answer += 1;
                }
            }
        }


        return answer;
    }
}
