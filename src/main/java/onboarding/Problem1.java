package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List<Integer> pobiLists = new ArrayList<>(maxScore(pobi));
        List<Integer> crongLsits = new ArrayList<>(maxScore(crong));
        int pobiMax = Math.max(pobiLists.get(0), pobiLists.get(1));
        int crongMax = Math.max(crongLsits.get(0), crongLsits.get(1));
        if (validateExamine(pobi, crong) == -1) {
            return -1;
        } else if (pobiMax > crongMax) {
            return 1;
        } else if (crongMax > pobiMax) {
            return 2;
        } else {
            return 0;
        }
    }

    public static List<Integer> maxScore(List<Integer> list) {
        List<Integer> box = new ArrayList<>();
        for (Integer integer : list) {
            int length = integer.toString().length();
            if (length == 1) {
                box.add(integer);
            } else if (length == 2) {
                int sum1 = integer / 10;
                int sum2 = integer % 10;
                box.add(Math.max(sum1 + sum2, sum1 * sum2));
            } else if (length == 3) {
                int sum1 = integer / 100;
                int sum2 = (integer % 100) / 10;
                int sum3 = (integer % 100) % 10;
                box.add(Math.max(sum1 + sum2 + sum3, sum1 * sum2 * sum3));
            }
        }
        return box;
    }

    public static int validateExamine(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) < 1 || pobi.get(1) < 1 || crong.get(0) < 1 || crong.get(1) < 1) {                   // 1보다 작은 경우
            return -1;
        } else if (pobi.get(0) > 400 || pobi.get(1) > 400 || crong.get(0) > 400 || crong.get(1) > 400) {    // 400보다 큰 경우
            return -1;
        } else if (pobi.size() > 2 || crong.size() > 2) {                                                   // 길이가 2보다 큰 경우
            return -1;
        } else if (pobi.get(0) == 0 || pobi.get(1) == 0 || crong.get(0) == 0 || crong.get(1) == 0) {        // 0과 같은경우
            return -1;
        } else if (pobi.get(0) != pobi.get(1) - 1 || crong.get(0) != crong.get(1) - 1) {                    // 왼쪽 페이지수와 오른쪽 페이지수 차이가 1이 아닌경우
            return -1;
        } else if (Objects.equals(pobi.get(0), pobi.get(1)) || Objects.equals(crong.get(0), crong.get(1))) { // 왼쪽페이지 수와 오른쪽 페이지 수가 같을경우
            return -1;
        } else if (pobi.get(0) % 2 != 1 || pobi.get(1) % 2 != 0 || crong.get(0) % 2 != 1 || crong.get(1) % 2 != 0) { // 왼쪽페이지가 홀수, 오른쪽 페이지가 짝수가 아닌 경우
            return -1;
        } else if (pobi.get(0) > pobi.get(1) || crong.get(0) > crong.get(1)) {                                  // 왼쪽 페이지 수가 더 큰 경우
            return -1;
        } else {
            return 0;
        }
    }
}