package onboarding;

/**
 * 기능 요구사항
 * 1. 3,6,9 박수 구현
 * 2. solution 구현
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=0; i<=number; i++){
            answer += getCount(i);
        }
        return answer;
    }

    public static int getCount(int number){
        String s = String.valueOf(number);
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            char num = s.charAt(i);
            if(num == '3' || num =='6' || num =='9')
                cnt++;
        }
        return cnt;
    }
}
