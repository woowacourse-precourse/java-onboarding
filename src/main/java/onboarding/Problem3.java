package onboarding;

import static java.lang.String.valueOf;
import static onboarding.problem3.Controller.getCount;
import static onboarding.problem3.Repository.save;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 누적 기능
        for (int i = 1; i <= number; i++) {

            int digitOne = i % 10;
            int digitTen = i / 10;


        // 규칙 기능
            if (i==33 || i==66 || i==99) { answer += 2; break;}
            if (i==333 || i==666 || i==999) { answer += 3; break;}
            if (i==3333 || i==6666 || i==9999) { answer += 4; break;}   //  1~10000이하 자연수 범위 속 3,6,9 중첩 규칙
            if(digitOne == 3 || digitOne == 6 || digitOne == 9){    answer += 1;    } // 1의 자리 3,6,9 규칙
            if(digitTen == 3 || digitTen == 6 || digitTen == 9) {   answer += 1;    } // 10의 자리 3,6,9 규칙

        }

        // refactor : 캡슐화
//        int repository = save(number);
//        int count = getCount(repository);

        return answer;
    }
}
