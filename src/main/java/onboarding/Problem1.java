package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        int leftPage = 0;
        int rightPage = 1;


        if (checkException(pobi.get(leftPage), pobi.get(rightPage)) &&
                checkException(crong.get(leftPage), crong.get(rightPage))) {
            int pobiScore = Math.max(findScore(pobi.get(leftPage)), findScore(pobi.get(rightPage)));
            int crongScore = Math.max(findScore(crong.get(leftPage)), findScore(crong.get(rightPage)));
            answer = compareScore(pobiScore, crongScore);
        }

        return answer;
    }

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
    //자리수를 알아내 리스트에 저장
    public static List<Integer> findPlaceValue(int num) {
        List<Integer> num_list = new ArrayList<>();

        while(num > 0) {
            num_list.add(num % 10);
            num /= 10;
        }

        return num_list;
    }

    public static int findScore(int number) {
        int sumResult = calculation(findPlaceValue(number), '+');
        int multiplicationResult = calculation(findPlaceValue(number), '*');

        return Math.max(sumResult,  multiplicationResult);
    }

    //점수 비교해 결과 반환
    public static int compareScore(int pobiScore, int crongScore) {
        if (pobiScore == crongScore)
            return 0;
        if (pobiScore > crongScore)
            return 1;
        if (pobiScore < crongScore)
            return 2;

        return -1;
    }

    /*
    * 예외 처리
    */
    public static boolean checkException(int leftPage, int rightPage) {
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
