package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        /* 예외처리 */
        if (pobi.size() > 2 || crong.size() > 2) {
            answer = -1;
            return answer;
        }

        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            answer = -1;
            return answer;
        }

        if (pobi.get(0) == 1 || pobi.get(0) == 399) {
            answer = -1;
            return answer;
        }

        if (crong.get(0) == 1 || crong.get(0) == 399) {
            answer = -1;
            return answer;
        }

        /* 포비 크롱 최댓값 비교 */
        int pobiRealMax = getMax(pobi);
        int crongRealMax = getMax(crong);

        if (pobiRealMax > crongRealMax) {
            answer = 1;
        }
        if (pobiRealMax == crongRealMax) {
            answer = 0;
        }
        if (pobiRealMax < crongRealMax) {
            answer = 2;
        }


        return answer;
    }

    /**
     * 왼쪽페이지 오른쪽페이지 비교 후 최댓값 구하는 메서드
     *
     * @param number
     * @return
     */
    public static int getMax(List<Integer> number) {
        int left = getCalculate(number.get(0));
        int right = getCalculate(number.get(1));

        if (left > right) {
            return left;
        } else {
            return right;
        }
    }

    /**
     * 왼쪽페이지 오른쪽페이지 합or곱 비교해서 최댓값 구하는 메서드
     *
     * @param lastNumber
     * @return
     */
    public static int getCalculate(int lastNumber) {
        int add = 0;
        int multi = 1;

        String max = "" + lastNumber;
        for (int i = 0; i < max.length(); i++) {
            add += max.charAt(i) - 48;
            multi *= max.charAt(i) - 48;
        }
        if (add > multi) {
            return add;
        } else {
            return multi;
        }
    }
}