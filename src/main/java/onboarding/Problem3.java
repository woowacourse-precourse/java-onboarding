/*
3 6 9 13 16 19 23 26 29 30 30 32 33 34 35 36 37 38 39 40
1 ~ 10000으로 범위가 작으므로 시간복잡도에 대한 문제는 없을것 같음

예외사항
1, 입력값에 대한 예외처리
2, 
 */
package onboarding;

public class Problem3 {
  public static int solution(int number) {
        int answer = 0;
        int count = 0;

        for(int i = 1; i <= number; i++){
            String number_char = Integer.toString(i);
            int len_number = number_char.length();
            for(int k = 0; k<len_number;k++){
                if(number_char.charAt(k) == '3' || number_char.charAt(k) == '6' || number_char.charAt(k) == '9') count++;
            }
        }
        answer = count;
        return answer;
    }
}
