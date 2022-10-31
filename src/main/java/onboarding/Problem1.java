package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        /* 잘못된 값 들어왔을 때 종료시키는 예외처리 */
        int pobiNum1 = pobi.get(0);
        int pobiNum2 = pobi.get(1);
        int pobiDiff = pobiNum2 - pobiNum1;
        if(pobiNum1 % 2 ==0 || pobiNum1 > pobiNum2 || pobiDiff !=1 || pobiNum1 > 399 ||pobiNum2 > 400)
            return -1;
        int crongNum1 = crong.get(0);
        int crongNum2 = crong.get(1);
        int crongDiff = crongNum2 - crongNum1;
        if(crongNum1 % 2 ==0 || crongNum1 > crongNum2 || crongDiff !=1 || crongNum1 > 399 ||crongNum2 > 400)
            return -1;

        /* 포비가 만들수 있는 가장 큰 수 구하기*/
        int pobiMax = getMaxNumber(pobi);

        /* 크롱이 만들수 있는 가장 큰 수 구하기*/
        int crongMax = getMaxNumber(crong);

        if(pobiMax > crongMax) {
            return 1;
        } else if (pobiMax < crongMax){
            return 2;
        } else if (pobiMax == crongMax){
            return 0;
        }

        return -1;
    }
    /*가장 큰 수를 구하는 메소드*/
    public static int getMaxNumber(List<Integer> list){

        int leftNum = list.get(0);
        int rightNum = list.get(1);

        int leftAddNum = getAddition(leftNum);
        int leftMultiNum = getMultiplication(leftNum);
        int leftMaxNum = compareNum(leftAddNum, leftMultiNum);

        int rightAddNum= getAddition(rightNum);
        int rightMultiNum= getMultiplication(rightNum);
        int rightMaxNum = compareNum(rightAddNum, rightMultiNum);


        return compareNum( leftMaxNum, rightMaxNum);
    };

    /*각 자리의 숫자를 더해주는 메소드*/
    private static int getAddition(int num){
        int answer = 0;

        while(num > 0){
            answer += num%10;
            num/=10;
        }
        return answer;
    }
    /*각 자리의 숫자를 곱해주는 메소드*/
    private static int getMultiplication(int num){
        int answer = 1;

        while(num > 0){
            answer *= num%10;
            num/=10;
        }
        return answer;
    }
    /* 입력받은 숫자를 비교해서 큰 숫자를 반환하는 메소드 */
    private static int compareNum(int num1, int num2){
        return num1>num2 ? num1 : num2;
    }

}

