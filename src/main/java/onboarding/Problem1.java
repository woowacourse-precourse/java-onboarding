package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(detectError(pobi) || detectError(crong))
            return -1;

        int pobiNum = getMaxOfNumbers(pobi), crongNum = getMaxOfNumbers(crong);

        if(pobiNum == crongNum)
            return 0;
        else if(pobiNum > crongNum)
            return 1;
        else
            return 2;
    }

    //error 검출
    private static boolean detectError(List<Integer> list) {
        for(int element : list)
            if(element == 1 || element == 400)
                return true;

        if(list.get(0) % 2 == 1 && list.get(1) - list.get(0) == 1)
            return false;

        return true;
    }

    //리스트 안 숫자들의 getSum, getMultiple의 값들 중 최대값 구하기
    private static int getMaxOfNumbers(List<Integer> list){
        int ret = 0, num;

        for(int element : list) {
            num = getSumEachDigit(element);
            if(ret < num)
                ret = num;

            num = getMultipleEachDigit(element);
            if(ret < num)
                ret = num;
        }

        return ret;
    }

    //각 자리 숫자 더하기 값 구하기
    private static int getSumEachDigit(int num) {
        int ret = 0;

        while(num>0) {
            ret += num % 10;
            num /= 10;
        }

        return ret;
    }

    //각 자리 숫자 곱하기 값 구하기
    private  static int getMultipleEachDigit(int num) {
        int ret = 1;

        while(num>0) {
            ret *= num % 10;
            num /= 10;
        }

        return ret;
    }
}