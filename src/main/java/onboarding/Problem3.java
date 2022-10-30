package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        //1 ~ number 반복문
        for(int i = 1 ; i <= number ; i++){
            //3, 6, 9 제외 숫자 제거
            //3, 6, 9 개수만 셈
            answer+=Integer.toString(i).replaceAll("[^3|6|9]","").length();
        }
        return answer;
    }
}
