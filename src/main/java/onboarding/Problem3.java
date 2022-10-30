package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String str_number = "";

        for(int i = 1; i <= number; i++){
            str_number += String.valueOf(i);
        }
        answer = (int)str_number.chars().filter(ch -> ch == '3' || ch == '6' || ch == '9').count();

        return answer;
    }
}
