package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static final int leftPage = 0;
    static final int rightPage = 1;
    static final int exceptionNum = -1;
    static final int listSize = 2;
    static int errorNum = 244;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = exceptionNum;

        //길이가 2일 경우
        if (checkException(pobi.get(leftPage), pobi.get(rightPage)) && checkException(crong.get(leftPage), crong.get(rightPage)))
        {
            int pobiScore = Math.max(findScore(pobi.get(leftPage)), findScore(pobi.get(rightPage)));
            int crongScore = Math.max(findScore(crong.get(leftPage)), findScore(crong.get(rightPage)));
            answer = compareNum(pobiScore, crongScore);
        }

        return answer;
    }

    //자리수를 알아내 리스트에 저장
    public static List<Integer> findPlaceValue(int num) {
        List<Integer> num_list = new ArrayList<>();

        if (num == 0)
            num_list.add(num);
        while(num > 0) {
            num_list.add(num % 10);
            num /= 10;
        }

        return num_list;
    }
    //곱셈과 덧셈 연산 수행
    public static int calculation(List<Integer> num_list, char type) {
        int result = 0;

        //곱셈일 경우 초기화
        if (type == '*')
            result = 1;

        for (int i = 0; i < num_list.size(); i++) {
            if (type == '+')
                result += num_list.get(i);
            if (type == '*')
                result *= num_list.get(i);
        }

        return result;
    }

    //max 찾기
    public static int findScore(int number) {
        int sumResult = calculation(findPlaceValue(number), '+');
        int multiplicationResult = calculation(findPlaceValue(number), '*');

        return Math.max(sumResult,  multiplicationResult);
    }

    //점수 비교해 결과 반환
    public static int compareNum(int pobiNum, int crongNum) {
        //연산한 결과가 0일 경우
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

    /*
    * 예외 처리
    */
    //1. 왼쪽과 오른쪽이 연속한 숫자가 아닌 경우
    public static boolean checkException(int leftPage, int rightPage)
    {
        int firstPage = 1;
        int lastPage = 400;

        if (!(leftPage >= firstPage && leftPage <= lastPage))
            return false;
        if (!(rightPage >= firstPage && rightPage <= lastPage))
            return false;
        if ((leftPage % 2) == 0)
            return false;
        if ((leftPage + 1) != rightPage)
            return false;
        return true;
    }
}
