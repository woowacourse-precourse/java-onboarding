package onboarding;

import java.util.Arrays;

/*
- 기능 구현사항 목록 -
1. 1부터 입력값까지 for 문 실행
2. 해당 숫자를 문자열이 담긴 배열로 변환
3. 해당 배열에서 3/6/9 count -> answer += count
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i < number+1; i++) {
            int num = i;
            String temp = Integer.toString(num);
            int[] digits = new int[temp.length()];
            for (int j = 0; j < temp.length(); j++) digits[j] = temp.charAt(j) - '0';
            System.out.print( Arrays.toString(digits) );
        }
        return answer;
    }
}
