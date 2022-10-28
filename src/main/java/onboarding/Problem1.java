package onboarding;

import java.util.List;

/*
* 기능목록
*
* 1. 에러 처리 기능
* 2. 페이지 각 자리수 더해서 반환하는 기능
* 3. 페이지 각 자리수 곱해서 반환하는 기능
* 4. 3번과 4번 반환값에서 최댓값을 판별하는 기능
* 5. 최댓값을 비교하여 승자 판별하는 기능
*
* */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(checkException(pobi) == false || checkException(crong) == false)
            return -1;
        int pobiLeftMaxNumber = getMaxNumber(getPlusEachNumber(pobi.get(0)), getMultiplyEachNumber(pobi.get(0)));
        int pobiRightMaxNumber = getMaxNumber(getPlusEachNumber(pobi.get(1)), getMultiplyEachNumber(pobi.get(1)));
        int pobiMaxNumber = getMaxNumber(pobiLeftMaxNumber, pobiRightMaxNumber);

        int crongLeftMaxNumber = getMaxNumber(getPlusEachNumber(crong.get(0)), getMultiplyEachNumber(crong.get(0)));
        int crongRightMaxNumber = getMaxNumber(getPlusEachNumber(crong.get(1)), getMultiplyEachNumber(crong.get(1)));
        int crongMaxNumber = getMaxNumber(crongLeftMaxNumber, crongRightMaxNumber);

        if(pobiMaxNumber > crongMaxNumber)
            return 1;
        else if (pobiMaxNumber < crongMaxNumber)
            return 2;
        else
            return 0;
    }

    public static boolean checkException(List<Integer> list) {
        if (list.size() != 2)
            return false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null)
                return false;
        }

        if (list.get(1) - list.get(0) != 1)
            return false;
        if (list.get(0) % 2 != 1 || list.get(1) % 2 != 0)
            return false;
        if (list.get(0) == 1 || list.get(1) == 400)
            return false;
        if (list.get(0) < 1 || list.get(0) > 400 || list.get(1) < 1 || list.get(1) > 400)
            return false;
        return true;
    }

    public static int getPlusEachNumber(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;

            number /= 10;
        }
        return sum;
    }

    public static int getMultiplyEachNumber(int number) {
        int sum = 1;
        while (number > 0) {
            sum *= number % 10;

            number /= 10;
        }
        return sum;
    }

    public static int getMaxNumber(int number1, int number2) {
        return Math.max(number1, number2);
    }
}