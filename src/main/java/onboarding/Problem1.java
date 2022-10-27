package onboarding;

import java.util.List;

/*
* 기능목록
*
* 1. 에러 처리 기능
* 2. 페이지 각 자리수 더해서 반환하는 기능
* 3. 페이지 각 자리수 곱해서 반환하는 기능
* 4. 3번과 4번 반환값에서 최댓값을 판별하는 기능
* 5. 최댓값을 비교하여 승자 판별하는 기능
*
* */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;

    }

    public static boolean checkException(List<Integer> list) {
        if (list.size() != 2)
            return false;
        if (list.contains(null))
            return false;
        if (list.get(1) - list.get(0) != 1)
            return false;
        if (list.get(0) % 2 != 1 || list.get(1) % 2 != 0)
            return false;
        if (list.get(0) == 1 || list.get(1) == 400)
            return false;
        if (list.get(0) < 1 || list.get(0) > 400 || list.get(1) < 1 || list.get(1) > 400)
            return false;
        return true;
    }

    public static int getPlusSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;

            number /= 10;
        }
        return sum;
    }

    public static int getMultiplyEachNumber(int number) {
        int sum = 1;
        while (number > 0) {
            sum *= number % 10;

            number /= 10;
        }
        return sum;
    }
}