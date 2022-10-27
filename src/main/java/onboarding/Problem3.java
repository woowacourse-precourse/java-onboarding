package onboarding;

// 1 이상 10000 이하인 자연수를 받음
// 각각의 숫자의 자릿수를 분해해서 3,6,9의 갯수를 세야함
// 갯수의 총합을 return 해야함

// todo
// 1. 받은 매개변수까지 반복하는 반복문 만들기
// 2. 각 자릿수에 3,6,9가 몇개 들어가는지 검사
// 2-1. 숫자의 각 자릿수를 분해
// 2-2. 분해한 각 자릿수가 3,6,9인지 검사

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= 13; i++){
            System.out.println(i);
            System.out.println(returnDigit(i));
        }

        return answer;
    }

    public static List<Integer> returnDigit(int num){
        ArrayList<Integer> arrNum = new ArrayList<>();
        while(num > 0) {
            arrNum.add(num %10);
            num /= 10;
        }
        return arrNum;
    }

    public static int returnSumOfCondition(List<Integer>){
        int sum = 0;

        return sum;
    }
}

