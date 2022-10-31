package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}

class PageNumberGame {
    /**
     * 페이지 번호 게임에 쓰이는 메소드들을 정의한 클래스입니다.
     *
     * 모두 외부에 기능을 제공하기 위한 메소드들이고,
     * 인스턴스 변수의 값을 참조하거나 수정하지 않기 때문에
     * 불필요한 인스턴스의 생성을 줄이기 위해 클래스 메소드로 선언했습니다.
     *
     */
    public static int getSum(int num) {
        /**
         * 각 자리수에 해당하는 각각 숫자들의 합을 구하는 메소드
         *
         * @param 페이지 번호
         * @return 각 숫자들의 합
         */

        int[] arrNum = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(arrNum).sum();

        return sum;
    }

    public static int getMultiply(int num) {
        /**
         * 각 자리수에 해당하는 각각 숫자들의 곱을 구하는 메소드
         *
         * @param 페이지 번호
         * @return 각 숫자들의 곱
         */

        int[] arrNum = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        int mul = 1;

        for (int i : arrNum) {
            mul *= i;
        }

        return mul;
    }

    public static int getScore(List<Integer> pageList) {
        /**
         * 가장 큰 점수를 반환하는 메소드
         *
         * @param 펼친 페이지가 들어있는 리스트
         * @return 얻을 수 있는 최대의 점수를 반환
         * @throws pageList의 길이가 2가 아니거나, 페이지 번호가 순서대로 들어오지 않을 경우
         *         즉, ({@code pageList.size() != 2 || lst.get(1) - lst.get(0) != 1})
         */

        int maxScore;
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);

        List<Integer> scoreList = new ArrayList<>();

        scoreList.add(getSum(leftPage));
        scoreList.add(getMultiply(leftPage));

        scoreList.add(getSum(rightPage));
        scoreList.add(getMultiply(rightPage));

        maxScore = Collections.max(scoreList);

        return maxScore;
    }

    public static boolean catchException(List<Integer> lst) {
        int size = lst.size();
        int pageFlag = lst.get(1) - lst.get(0);

        if (size != 2 || pageFlag != 1) {
            return true;
        } else {
            return false;
        }
    }
}