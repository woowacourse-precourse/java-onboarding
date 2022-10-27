package onboarding;

import java.util.List;

//기능 목록
//1. 숫자를 주면 각 자리 숫자 모두 더하거나 모두 곱해 가장 큰 수 반환 함수
//2. List가 주어지면 가장 큰 값을 반환하는 함수
//3. 점수 비교해서 승자 정하기

class Problem1 {
    public int addOrMultiply(int num){
        int hun, ten, one=0;
        hun=num/100;
        ten=(num%100)/10;
        one=(num%100)%10;

        int addNum, mulNum=0;

        addNum=hun+ten+one;
        mulNum=hun*ten*one;

        if(addNum>mulNum)
            return addNum;
        else
            return mulNum;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}