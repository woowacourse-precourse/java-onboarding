package onboarding;

/*
    기능 명세
    1. getClap(int number) : 숫자를 입력받아서 3, 6, 9가 들어간 숫자만큼 clap 수를 반환하는 함수
 */

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += getClap(i);
        }
        return answer;
    }

    public static int getClap(int number) {
        int clap = 0;
        String str_num = Integer.toString(number);
        for (int i = 0; i < str_num.length(); i++) {
            if (str_num.charAt(i) == '3' || str_num.charAt(i) == '6' || str_num.charAt(i) == '9') {
                clap++;
            }
        }
        return clap;
    }
}
