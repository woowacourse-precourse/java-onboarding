package onboarding;


//SOL 1. 숫자를 문자열로 쪼개서 3, 6 9가 나올때마다 count를 증가시킨다.
//SOL 2. 숫자를 10으로 나눈 나머지를 3, 6 9 가 나오는 만큼 count를 증가시킨다.

import net.bytebuddy.asm.Advice;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

// 2번 채택
public class Problem3 {
    public static int solution(int number) {
        int answer = 0 ;

        for(int i = 3; i <= number; i++){
            int num = i;
            while(num > 0){     //수
                int mod = num % 10;
                if(mod == 3 || mod == 6 || mod == 9)
                    answer +=  1;
                num /= 10;
            }
        }
        return answer;
    }
    public static int solution2(int number) {
        int answer = 0;

        for(int i = 3; i <= number; i++){
            String s = String.valueOf(i);
            for(int j = 0; j < s.length(); j++){
                Character c = s.charAt(j);
                if(c.equals('3') || c.equals('6') || c.equals('9'))
                    answer+=1;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        System.out.println(solution(13000000));
        LocalDateTime end = LocalDateTime.now();
        System.out.println(Duration.between(start, end));

        LocalDateTime start2 = LocalDateTime.now();
        System.out.println(solution2(13000000));
        LocalDateTime end2 = LocalDateTime.now();
        System.out.println(Duration.between(start2, end2));
    }
}
