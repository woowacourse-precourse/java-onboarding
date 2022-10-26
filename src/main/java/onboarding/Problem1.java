package onboarding;

import java.util.ArrayList;
import java.util.List;

// 1~400페이지의 책
// 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수

// 홀수 각 자리의 숫자를 전부 더한 수, 전부 곱한 수,
// 짝수 각 자리의 숫자를 전부 더한 수, 전부 곱한 수
// 이렇게 4가지의 수 중 가장 큰 수를 본인의 점수로 한다

// 점수를 비교해 가장 높은 사람이 게임의 승자
// 시작 면이나 마지막 면이 나오지 않도록 한다

// 위 과정을 포비와 크롱에게 적용
// 포비와 크롱의 점수를 비교한다.

// todo
// 1. pobi와 crong리스트 안에 들어있는 숫자를 가져온다.
// 2. 가져온 숫자 각각의 자릿수를 분해
// 3. 분해한 각각의 숫자를 더하거나 곱했을때 가장 큰 수를 구한다.
// 3-1. 각각의 숫자를 더하고 곱하는 함수 만들기
// 3-2. 가장 큰 수 구하기

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_first = pobi.get(0);
        int pobi_second = pobi.get(1);

        int crong_first = crong.get(0);
        int crong_second = crong.get(1);

        System.out.println(returnDigit(pobi_second));
        System.out.println(sumOfArray(returnDigit(pobi_second)));
        System.out.println(multiOfArray(returnDigit(pobi_second)));

        System.out.println(max(sumOfArray(returnDigit(pobi_second)),multiOfArray(returnDigit(pobi_second))));



        System.out.println(returnDigit(crong_first));
        System.out.println(sumOfArray(returnDigit(crong_first)));
        System.out.println(multiOfArray(returnDigit(crong_first)));

        System.out.println(max(sumOfArray(returnDigit(crong_first)),multiOfArray(returnDigit(crong_first))));

        return answer;
    }

    // 숫자의 각 자릿수를 구하고, 리스트로 반환하는 함수
    public static List<Integer> returnDigit(int num){
        ArrayList<Integer> arrNum = new ArrayList<>();
        while(num > 0) {
            arrNum.add(num %10);
            num /= 10;
        }
        return arrNum;
    }

    // 배열의 모든 숫자의 합을 반환하는 함수
    public static int sumOfArray(List<Integer> arrNum){
        int sum = 0;
        for(Integer i : arrNum) { //for문을 통한 전체출력
            sum += i;
        }
        return sum;
    }

    // 배열의 모든 숫자의 곱을 반환하는 함수
    public static int multiOfArray(List<Integer> arrNum){
        int multi = 1;
        for(Integer i : arrNum) { //for문을 통한 전체출력
            multi *= i;
        }
        return multi;
    }

    public static int max(int a, int b){
        int max_int = a;
        if(b > max_int)
            max_int = b;
        return max_int;
    }
}