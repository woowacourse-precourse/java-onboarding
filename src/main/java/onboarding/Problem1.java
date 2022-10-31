package onboarding;

import java.util.List;

//기능 목록
//1. 숫자를 주면 각 자리 숫자 모두 더하거나 모두 곱해 가장 큰 수 반환 함수
//2. 2개 값이 주어지면 그 중 큰 값을 반환하는 함수
//3. 두 페이지가 차이가 1이 넘으면 -1 반환하는 함수
//4. 점수 비교해서 승자 정하기

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

    public static int getMaxNum(int left, int right){
        if(left>right)
            return left;
        else
            return right;
    }

    public static boolean checkPage(List<Integer>arr) {
        if((arr.get(1)-arr.get(0))>1)
            return false;
        else
            return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(checkPage(pobi)&&checkPage(crong)) {
            int pobiNum=getMaxNum(addOrMultiply(pobi.get(0)),addOrMultiply(pobi.get(1)));
            int crongNum=getMaxNum(addOrMultiply(crong.get(0)),addOrMultiply(crong.get(1)));

            if(pobiNum>crongNum)
                answer=1;
            else if(pobiNum<crongNum)
                answer=2;
            else
                answer=0;

            return answer;
        }
        else
            return -1;
    }
}