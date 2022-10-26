package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 포비 점수
        int pobi_sum = sum(pobi);
        int pobi_multi = multi(pobi);

        int pobi_max = max(pobi_sum, pobi_multi);

        // 크롱 점수
        int crong_sum = sum(crong);
        int crong_multi = multi(crong);

        int crong_max = max(crong_sum, crong_multi);

        // 리턴값 계산
        if(pobi_max > crong_max){
            return 1;
        }
        if (pobi_max == crong_max){
            return 0;
        }
        if (pobi_max < crong_max) {
            return 2;
        }
        return -1;
    }

    // 더하기
    private static int sum(List<Integer> value) {

        int value1 = 0;
        int value2 = 0;

        String[] array1 = String.valueOf(value.get(0)).split("");
        for (String val : array1) {
            value1 = value1 + Integer.valueOf(val);
        }

        String[] array2 = String.valueOf(value.get(1)).split("");
        for (String val : array2) {
            value2 = value2 + Integer.valueOf(val);
        }

        return max(value1, value2);
    }

    // 곱하기
    private static int multi(List<Integer> value) {

        int value1 = 1;
        int value2 = 1;

        String[] array1 = String.valueOf(value.get(0)).split("");
        for (String val : array1) {
            value1 = value1 * Integer.valueOf(val);
        }

        String[] array2 = String.valueOf(value.get(1)).split("");
        for (String val : array2) {
            value2 = value2 * Integer.valueOf(val);
        }

        return max(value1, value2);
    }

    // 최댓값
    private static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

}