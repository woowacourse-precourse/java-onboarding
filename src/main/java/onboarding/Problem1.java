package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        boolean flag = checkInput(pobi, crong);
        if (flag) {
//            int maxPobi = calMaxValue(pobi);
//            int maxCrong = calMaxValue(crong);

        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    // 입력 값이 제대로 되어 있는지 확인하는 함수
    public static boolean checkInput(List<Integer> arr1, List<Integer> arr2) {

        // 입력 값이 연속된 수인지 확인. 연속된 수가 아니면 0반환
        if (arr1.get(0) != arr1.get(1) - 1) {
            return false;
            // 입력 값이 1 또는 400을 포함하는 경우
        } else if (arr1.get(0) == 1 || arr2.get(0) == 1 || arr1.get(1) == 400 || arr2.get(1) == 400) {
            return false;
        }
        // 입력 값이 정상적인 경우
        return true;
    }

    public static int calMaxValue(List<Integer> arr) {
        int page1 = arr.get(0);
        int page2 = arr.get(1);

        int maxPage1;
        int maxPage2;
        if (sumValue(page1) >= multiValue(page1)) {
            maxPage1 = sumValue(page1);
        } else {
            maxPage1 = multiValue(page1);
        }
        if (sumValue(page2) >= multiValue(page2)) {
            maxPage2 = sumValue(page2);
        } else {
            maxPage2 = multiValue(page2);
        }

        if (maxPage1 >= maxPage2) {
            return maxPage1;
        } else {
            return maxPage2;
        }

    }

    public static int sumValue(int num) {
        int sum = 0;
        while (num != 0) {
            // 10으로 나눈 나머지를 차례대로 더해줌
            sum += num % 10;
            // 일의 자리부터 한 자리씩 소거
            num /= 10;
        }
        return sum;
    }

    public static int multiValue(int num) {
        int multi = 1;
        while (num != 0) {
            // 10으로 나눈 나머지를 차례대로 곱해줌
            multi *= num % 10;
            // 일의 자리부터 한 자리씩 소거
            num /= 10;
        }
        return multi;
    }





}

