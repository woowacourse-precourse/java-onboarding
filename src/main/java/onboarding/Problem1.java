package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static final int leftPage = 0;
    static final int rightPage = 1;
    static final int exceptionNum = -1;
    static int errorNum = 244;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //null일 경우
        if (exceptionCheck(pobi) || exceptionCheck(crong))
            return exceptionNum;

        int pobiScore = Math.max(findScore(pobi.get(leftPage)), findScore(pobi.get(rightPage)));
        int crongScore = Math.max(findScore(crong.get(leftPage)), findScore(crong.get(rightPage)));

        answer = compareNum(pobiScore, crongScore);

        return answer;
    }

    //자리수를 알아내서 배열에 저장하는 함수
    public static List<Integer> findPlaceValue(int number) {
        List<Integer> numberList = new ArrayList<>();

        if (number == 0)
            numberList.add(number);
        while(number > 0)
        {
            numberList.add(number % 10);
            number /= 10;
        }

        return numberList;
    }
    //곱셈과 덧셈을 하는 함수
    public static int calculation(List<Integer> numberList, char type) {
        int result = 0;

        if (type == '*')
            result = 1;

        for (int i = 0; i < numberList.size(); i++) {
            if (type == '+')
                result += numberList.get(i);
            if (type == '*')
                result *= numberList.get(i);
        }

        return result;
    }

    //연산한 값의 max값을 찾기
    public static int findScore(int number) {
        int sumResult = calculation(findPlaceValue(number), '+');
        int multiplicationResult = calculation(findPlaceValue(number), '*');

        return Math.max(sumResult,  exceptionCheck(multiplicationResult));
    }

    //점수 비교 후 결과 반환
    public static int compareNum(int pobiNum, int crongNum) {
        if (pobiNum >= errorNum || crongNum >= errorNum)
            return -1;
        if (pobiNum == crongNum)
            return 0;
        if (pobiNum > crongNum)
            return 1;
        if (pobiNum < crongNum)
            return 2;
        return -1;
    }

    //연산한 값에 0이 있을 경우
    public static int exceptionCheck(int num) {
        if (num >= 1)
            return errorNum;
        return num;
    }

    //size가 없을 경우
    public static boolean exceptionCheck(List<Integer> numList) {
        if (numList.size() == 0)
            return true;
        return false;
    }
}
