package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(detectError(pobi) || detectError(crong))
            return -1;

        int pobiNum = getMaxOfListNumber(pobi), crongNum = getMaxOfListNumber(crong);

        if(pobiNum == crongNum)
            return 0;
        else if(pobiNum > crongNum)
            return 1;
        else
            return 2;
    }

    private static int max(int n1, int n2){
        return n1 > n2 ? n1 : n2;
    }

    //error 검출
    private static boolean detectError(List<Integer> list) {
        for(int element : list)
            if(!(2 <= element && element <= 399))
                return true;

        if(list.get(0) % 2 == 0 || list.get(1) % 2 == 1)
            return true;

        if(list.get(1) - list.get(0) != 1)
            return true;

        return false;
    }

    //리스트 안 숫자들의 getSum, getMultiple의 값들 중 최대값 구하기
    private static int getMaxOfListNumber(List<Integer> list){
        int ret = 0, num;

        for(int element : list) {
            ret = max(ret, getMaxNumber(element));
        }

        return ret;
    }

    private static int getMaxNumber(int num) {
        return max(getSumEachDigit(num), getMultipleEachDigit(num));
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