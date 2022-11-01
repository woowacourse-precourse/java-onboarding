package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int chk_num = 1; chk_num <= number; chk_num++) {
            String str = String.valueOf(chk_num);

            for (int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);
                if (tmp == '3' || tmp == '6' || tmp == '9') {
                    answer +=1;
                }
            }
        }

        return answer;
    }
}
