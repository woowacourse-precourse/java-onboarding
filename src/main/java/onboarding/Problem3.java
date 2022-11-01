package onboarding;


//SOL 1. 숫자를 문자열로 쪼개서 3, 6 9가 나올때마다 count를 증가시킨다.
//SOL 2. 숫자를 10으로 나눈 나머지를 3, 6 9 가 나오는 만큼 count를 증가시킨다.

import net.bytebuddy.asm.Advice;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

// 2번 채택
public class Problem3 {
    public static int solution(int number)  {

        try{
            int answer = 0 ;
            valid(number);
            for(int i = 3; i <= number; i++){
                int num = i;
                while(num > 0){
                    int mod = num % 10;
                    if(mod == 3 || mod == 6 || mod == 9)    //각자릿 수 마다 3, 6, 9가 존재하면 answer 1 증가
                        answer +=  1;
                    num /= 10;
                }
            }
            return answer;
        }catch(Exception e){
            System.out.println(e);
            return -1;
        }

    }
    public static int solution2(int number) throws Exception {
        int answer = 0;
        valid(number);
        for(int i = 3; i <= number; i++){
            String s = String.valueOf(i);
            for(int j = 0; j < s.length(); j++){
                Character c = s.charAt(j);
                if(c.equals('3') || c.equals('6') || c.equals('9')) //이것도 solution1과 거의 동일하지만 문자로 작성
                    answer+=1;
            }
        }
        return answer;
    }

    public static void valid(Integer num) throws Exception {
        if(num < 1 || num > 10000){
            throw new Exception("입력값이 1이상 10,000이하인 자연수의 조건에서 벗어납니다.");
        }
    }

}
