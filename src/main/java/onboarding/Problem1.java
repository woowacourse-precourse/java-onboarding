package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

     /*
     * 페이지 번호의 각 자리 숫자의 값을 리스트로 반환하는 함수
     * parameter : int
     * return : List<Integer>
     * */
    public static List<Integer> toList(int x) {
        List<Integer> output = new ArrayList<>();
        while(x != 0) {
            output.add(x % 10);
            x = x / 10;
        }
        return output;
    }

    /*
     * 리스트의 전체 값을 더하거나, 곱해서 가장 큰 수를 반환하는 함수
     * parameter : List
     * return : int
     * */
    public static int maxNum(List<Integer> list) {
        int result = Integer.max(
                list.stream().reduce(0, Integer::sum),
                list.stream().reduce(1, (a, b) -> a*b));

        return result;
    }

    /*
     * 기능 요구사항 4. 양쪽 페이지의 큰 수를 비교해서 높은 숫자를 반환하는 함수
     * parameter : List
     * return : int
     * */
    public static int calScore(List<Integer> list) {
        int leftPage = list.get(0);
        int rightPage = list.get(1);
        List<Integer> leftPageList = toList(leftPage);
        List<Integer> rightPageList = toList(rightPage);

        int result = Integer.max(maxNum(leftPageList), maxNum(rightPageList));

        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiScore = calScore(pobi);
        int crongScore = calScore(crong);
        int result = 0;

        if (pobiScore > crongScore) result = 1;
        else if (pobiScore < crongScore) result = 2;
        else result = 0;

        return result;
    }
}