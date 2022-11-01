package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int temp, i = 1;
        while (i <= number) {
            temp = i;
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == '3' || ch == '6' || ch == '9') {
                    answer++;
                }
            }
            i++;

        }
        return answer;
    }
}
