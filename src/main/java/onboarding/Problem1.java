package onboarding;

import java.util.List;

//기능 목록
//1. 숫자를 주면 각 자리 숫자 모두 더하거나 모두 곱해 가장 큰 수 반환 함수
//2. List가 주어지면 가장 큰 값을 반환하는 함수
//3. 점수 비교해서 승자 정하기

class Problem1 {
    public static int addOrMultiply(int num){

        int addNum=0, mulNum=1;

        while(num>0) {
            addNum += num % 10;
            mulNum *= num % 10;
            num /= 10;
        }

        if(addNum>mulNum)
            return addNum;
        else
            return mulNum;
    }

    public static int getMaxNum(List<Integer> numList){
        int max=0;
        for(int i=0;i<numList.size();i++){
            if(max>numList.get(i)){
                max=numList.get(i);
            }
        }
        return max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
}