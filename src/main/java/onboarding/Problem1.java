package onboarding;

import java.util.List;

class Problem1 {

    // 입력값은 포비의 왼오 번호와 크롱의 왼오 번호 각각 두개씩 들어온다.
    // 계산을 함으로써
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 숫자가 두개씩 들어오지 않았거나 리스트 자체가 비었거나 리스트는 있는데 값이 덜 들어 있으면 에러 처리
        if (pobi == null || pobi.isEmpty() || pobi.size() != 2)
            return -1;
        if (crong == null || crong.isEmpty() || crong.size() != 2)
            return -1;
        if (!validValue(pobi) || !validValue(crong))
            return -1;

        int pobi_max;
        int crong_max;

        pobi_max = findMaxValue(pobi.get(0));
        crong_max = findMaxValue(crong.get(0));

        pobi_max = Math.max(pobi_max, findMaxValue(pobi.get(1)));
        crong_max = Math.max(crong_max, findMaxValue(crong.get(0)));

        // 숫자가 int범위를 넘어서 오버플로우 나면 에러 처리
        if (pobi_max < 0 || crong_max < 0)
            return -1;

        if (pobi_max > crong_max)
            return 1;
        else if (pobi_max < crong_max)
            return 2;
        else
            return 0;
    }

    private static boolean validValue(List<Integer> list) {
        int right = list.get(0).intValue() % 2;

        if (list.get(0).intValue() % 2 == 0) // 홀수가 아니면
            return false;
        if (list.get(1).intValue() % 2 == 1) // 짝수가 아니면
            return false;
        if (list.get(0) + 1 != list.get(1)) // 연속된 숫자가 아니면
            return false;
        return true;
    }

    // 들어온 숫자로 만든 곱과 합중 더 큰 값을 리턴한다.
    private static int findMaxValue(int number) {

        return (Math.max(sumNumber(number), multiNumber(number)));
    }

    private static int sumNumber(int num) {

        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static int multiNumber(int num) {
        int multi = 0;

        while (num > 0) {
            multi *= num % 10;
            num /= 10;
        }
        return multi;
    }
}