package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = -1;
        int crongScore = -1;

        if (checkRestrictions(pobi) == -1 || checkRestrictions(crong) == -1) {
            return -1;
        }

        pobiScore = getScore(pobi, pobiScore);
        crongScore = getScore(crong, crongScore);

        if (pobiScore == crongScore) {
            answer = 0;
        } else if (pobiScore > crongScore) {
            answer = 1;
        } else {
            answer = 2;
        }

        return answer;
    }

    /**
     * 제한사항을 위배했는지 체크하는 메서드
     * @param list
     * @return
     */
    private static Integer checkRestrictions(List<Integer> list) {
        int[] pobiArr = list.stream().mapToInt(i -> i).toArray();
        if (pobiArr.length != 2) {
            return -1;
        }
        if (pobiArr[1] - pobiArr[0] != 1) {
            return -1;
        }
        return 0;
    }

    /**
     * 한자리씩 쪼갠 숫자의 합과 곱을 계산하여 score 의 최댓값 갱신
     * @param list
     * @param score
     * @return
     */
    private static int getScore(List<Integer> list, int score) {
        for (Integer i : list) {
            List<Integer> splited = split(i);
            score = Math.max(score, doAdd(splited));
            score = Math.max(score, doMultiply(splited));
        }
        return score;
    }

    /**
     * 숫자를 한자리씩 쪼개어 리스트로 반환하는 메서드
     * @param num
     * @return
     */
    private static List<Integer> split(Integer num) {
        List<Integer> arrNum = new ArrayList<>();
        while (num > 0) {
            arrNum.add(num % 10);
            num /= 10;
        }
        return arrNum;
    }

    /**
     * 리스트의 요소를 모두 더하는 메서드
     * @param arr
     * @return
     */
    private static Integer doAdd(List<Integer> arr) {
        Integer result = 0;
        for (Integer integer : arr) {
            result += integer;
        }
        return result;
    }

    /**
     * 리스트의 요소를 모두 곱하는 메서드
     * @param arr
     * @return
     */
    private static Integer doMultiply(List<Integer> arr) {
        Integer result = 1;
        for (Integer integer : arr) {
            result *= integer;
        }
        return result;
    }
}