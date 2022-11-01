package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    // 첫번째 아이디어
    // 예외 ->  1. 왼/오 페이지 숫자가 1 차이보다 클 때 2. 1~400페이지 안이 아닐 때 3. 홀/짝 바뀔 때
    // 함수를 만들어 예외가 발생하는 경우에는 true를 반환하도록 함
    // 포비와 크롱 각각 오른쪽/왼쪽 페이지의 합과 곱 중 더 큰 수를 반환하는 함수를 만들기
    // 포비와 크롱 각각 오른쪽 최댓값 왼쪽 최댓값 비교해 더 큰 수 반환하는 함수 만들기
    // 출력된 두 값 비교해 return 값 설정하기 (return 값은 1, 2, 0 중 하나)

    public static boolean exceptionCase(List<Integer> list) {
        boolean excepted = false;
        if(list.get(1) - list.get(0) != 1) {
            excepted = true;
        } else if(list.get(0) < 1 && list.get(0) >= 400 && list.get(1) < 1 && list.get(1) > 400) {
            excepted = true;
        } else if(list.get(0) % 2 == 0 || list.get(1) % 2 == 1) {
            excepted = true;
        }
        return excepted;
    }

    public static int maxValueOfPage(int page) {
        String toString = String.valueOf(page);
        int add = 0;
        int multi = 1;
        for(int i = 0; i < toString.length(); i++) {
            add += Character.getNumericValue(toString.charAt(i));
            multi *= Character.getNumericValue(toString.charAt(i));
        }
        return Math.max(add, multi);
    }

    public static int maxValue(int odd_max, int even_max) {
        return Math.max(odd_max, even_max);
    }

    public static int finalValue(int page1_max, int page2_max) {
        int finalValue = 0;
        if(page1_max > page2_max) {
            finalValue = 1;
        } else if(page1_max < page2_max) {
            finalValue = 2;
        }
        return finalValue;
    }

    public static int[] changeArr(List<Integer> list) {
        int[] arr = new int[2];
        for(int i = 0; i < 2; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(exceptionCase(pobi) || exceptionCase(crong)) {
            return -1;
        } else {
            int pobi_max = maxValue(maxValueOfPage(pobi.get(0)), maxValueOfPage(pobi.get(1)));
            int crong_max = maxValue(maxValueOfPage(crong.get(0)), maxValueOfPage(crong.get(1)));
            return finalValue(pobi_max, crong_max);
        }
    }
}