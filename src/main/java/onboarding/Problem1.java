package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //예외상황 확인
        if (isException(pobi) || isException(crong)) return -1;

        //pobi의 수 구하기
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int pobiNum = getSumOrMultiply(pobiLeft,pobiRight);

        //crong의 수 구하기
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);
        int crongNum = getSumOrMultiply(crongLeft,crongRight);

        //승자 구하기
        int winner = getWinner(pobiNum,crongNum);
        System.out.println(winner);
        return winner;
    }

    //각 자리를 더하는 함수
    public static int getSum(int num) {
        int sum = 0;
        while (num > 10) {
            sum += (num % 10);
            num /= 10;
        }
        sum += num;
        return sum;
    }

    //각 자리를 곱하는 함수
    public static int getMultiply(int num) {
        int multiply = 1;
        while (num > 10) {
            multiply *= (num % 10);
            num /= 10;
        }
        multiply *= num;
        return multiply;
    }

    //두 숫자 크기를 비교하여 큰 값을 반환하는 함수
    public static int getBigNumber(int sum, int multiply) {
        if (sum == multiply || sum > multiply) return sum;
        return multiply;
    }

    //승자를 가리는 함수
    public static int getWinner(int pobi, int crong) {
        if (pobi == crong) return 0;
        if (pobi > crong) return 1;
        return 2;
    }

    //예외상황을 판별하는 함수
    public static boolean isException(List<Integer> list) {

        //연속된 두 페이지가 아니거나 왼쪽페이지 쪽수가 오른쪽 페이지 쪽수보다 큰 경우
        if (list.get(1) - list.get(0) != 1) return true;

        //시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다는 조건에 해당하는 예외상황
        if (list.get(0) == 1 || list.get(1) == 400) return true;

        return false;
    }

    //각 자리 합과 곱 중 더 큰 값을 골라주는 함수
    public static int getSumOrMultiply(int left, int right){
        int leftSum = getSum(left);
        int leftMultiply = getMultiply(left);
        int leftBigNum = getBigNumber(leftSum, leftMultiply);

        int rightSum = getSum(right);
        int rightMultiply = getMultiply(right);
        int rightBigNum = getBigNumber(rightSum, rightMultiply);

        int bigNum = getBigNumber(leftBigNum, rightBigNum);

        return bigNum;
    }
}