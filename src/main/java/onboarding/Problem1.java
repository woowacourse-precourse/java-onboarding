package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static final int leftPage = 0;
    static final int rightPage = 1;
    static final int userListSize = 2;

    static int errorNum = 250;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        int pobiScore = Math.max(findScore(pobi.get(leftPage)), findScore(pobi.get(rightPage)));
        int crongScore = Math.max(findScore(crong.get(leftPage)), findScore(crong.get(rightPage)));

        answer = compareNum(pobiScore, crongScore);

        return answer;
    }

    //자리수를 알아내서 배열에 저장하는 함수
    public static List<Integer> findPlaceValue(int number) {
        List<Integer> numberList = new ArrayList<>();

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

        return Math.max(sumResult, multiplicationResult);
    }

    //점수 비교 후 결과 반환
    public static int compareNum(int pobiNum, int crongNum) {
        if (pobiNum == errorNum || crongNum == errorNum)
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
    public static int exceptionCheck(int multiplyNum) {
        if (multiplyNum == 0)
            return errorNum;
        return multiplyNum;
    }
}
