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

        answer = compareNum(findMaxNumber(pobi.get(leftPage), pobi.get(rightPage)), findMaxNumber(crong.get(leftPage), crong.get(rigitPage)));

        return answer;
    }

    //자리수를 알아내서 배열에 저장하는 함수
    public static List<Integer> findPlaceValue(int number)
    {
        List<Integer> numberList = new ArrayList<>();

        while(number > 0)
        {
            numberList.add(number % 10);
            number /= 10;
        }

        return numberList;
    }

    //곱셈과 덧셈을 하는 함수
    public static int[] calculation(List<Integer> numberList) {
        int sum = 0;
        int multiply = 0;
        int[ ] resultArray = new int[userListSize];

        for (int i = 0; i < numberList.size(); i++) {
            sum += numberList.get(i);
            multiply *= numberList.get(i);
        }

        resultArray[leftPage] = sum;
        resultArray[rightPage] = multiply;

        return resultArray;
    }

    //점수 구하기 : 연산한 값의 max값을 찾기
    public static int findScore(int number)
    {
        int sum = 0;
        int multiply = 1;

        int[ ] numArray;

        numArray = calculation(findPlaceValue(number));

        return Math.max(numArray[sum], numArray[multiply]);
    }

    //점수 비교 후 결과 반환
    public static int compareNum(int pobiNum, int crongNum)
    {
        if (pobiNum == errorNum || crongNum == errorNum)
            return -1;
        if (pobiNum == crongNum)
            return 0;
        else if (pobiNum > crongNum)
            return 1;
        else if (pobiNum < crongNum)
            return 2;

        return -1;
    }

    //연산한 값에 0이 있을 경우
    public static int exceptionCheck(int multiplyNum)
    {
        if (multiplyNum == 0)
            return errorNum;
        return multiplyNum;
    }
}
