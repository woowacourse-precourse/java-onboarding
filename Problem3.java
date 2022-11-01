package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        if (number < 1 || number > 10000) {
            return -1;
        }

        int count369 = 0;

        for (int i = 1; i <= number; i++) {
            List<Integer> digitArray = digit(i);

            for (int index = 0; index < digitArray.size(); index++) {
                if (digitArray.get(index) % 3 == 0 && digitArray.get(index) != 0) {
                    count369 += 1;
                }
            }
        }

        int answer = count369;
        return answer;
    }

    public static List<Integer> digit(int number) { //자릿수를 추출 input은 number로 정의(왼,오 쪽수가 되겠죵??)
        List<Integer> digitArr = new ArrayList<>();//추출한 자릿수를 넣을 빈 배열 선언

        int num = number;

        while(num > 0) { //자릿수가 0보다 커야 됨...! 즉, 모든 자릿수에 대해 반복
            digitArr.add(num %10); //빈 배열에 숫자를 10으로 나눈 나머지 즉 1의 자리를 넣는다
            num /= 10; //숫자를 10으로 나눈다 즉, 1의 자리를 없앰
        }

        return digitArr; //채워진 배열을 반환
    }
}


