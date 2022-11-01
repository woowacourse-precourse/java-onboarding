package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        try{
            validate(pobi);
        } catch(IllegalArgumentException e){
            return -1;
        }

        int pobiValue = compareSumWithMultiplyValue(pobi);
        int crongSum = compareSumWithMultiplyValue(crong);

        return 0;
    }

    //유효한 좌우 페이지인지 확인
    public static void validate(List<Integer> pages){

        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if(leftPage+1 == rightPage)
            return;

        throw new IllegalArgumentException();
    }

    public static int compareSumWithMultiplyValue(List<Integer> user){

        int leftPage = user.get(0);
        int rightPage = user.get(1);

        int sumValue = sumAndCompareLeftRight(user,leftPage,rightPage);
        int multiplyValue = multiplyAndCompareLeftRight(user,leftPage,rightPage);

        return returnBiggerValue(sumValue,multiplyValue);
    }

    public static int sumAndCompareLeftRight(List<Integer> user, int leftPage, int rightPage){

        int leftPageNumSum = sum(leftPage);
        int rightPageNumSum = sum(rightPage);

        return returnBiggerValue(leftPageNumSum,rightPageNumSum);
    }

    public static int multiplyAndCompareLeftRight(List<Integer> user, int leftPage, int rightPage){
        int leftPageNumSum = multiply(leftPage);
        int rightPageNumSum = multiply(rightPage);

        return returnBiggerValue(leftPageNumSum,rightPageNumSum);
    }

    //각 자리 숫자를 더하기
    public static int sum(int page) {

        int result = 0;

        while (page > 10) {
            int mod = page % 10;
            page /= 10;
            result += mod;
        }
        result += page;

        return result;
    }

    //각 자리 숫자를 곱하기
    public static int multiply(int page){

        int result = 1;

        while (page > 10){
            int mod = page % 10;
            page /= 10;
            result *= mod;
        }
        result *= page;

        return result;
    }

    //둘 중 큰 수를 반환
    public static int returnBiggerValue(int value1, int value2){
        return Math.max(value1,value2);
    }
}