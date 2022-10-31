package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (i > 10) {
                String str = String.valueOf(i);
                char[] ch = str.toCharArray();
                for (int j = 0; j < str.length(); j++) {
                    if (ch[j] == '3' || ch[j] == '6' || ch[j] == '9') {
                        answer++;
                    }
                }
            } else {
                if (i == 3 || i == 6 || i == 9)
                    answer++;
            }
        }
        return answer;
    }
}
