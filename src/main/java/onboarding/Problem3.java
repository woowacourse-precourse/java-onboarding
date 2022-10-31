package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += check369(i);
        }
        return answer;
    }
    public static int check369(int number){
        String str= Integer.toString(number);
        int cnt=0;
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp == '3' || tmp == '6' || tmp == '9') {
                cnt++;
            }
        }
        return cnt;
    }
}
