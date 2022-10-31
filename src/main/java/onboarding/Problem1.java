package onboarding;

import java.util.List;

class Problem1 {

    // 입력 예외처리
    public static void inputException(List<Integer> pobi, List<Integer> crong) throws Exception {
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) throw new Exception();
        if (pobi.get(0) < 0 || pobi.get(1) > 400) throw new Exception();
        if (crong.get(0) < 0 || crong.get(1) > 400) throw new Exception();
        if (pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1) throw new Exception();
        if (pobi.get(1) % 2 != 0 || crong.get(1) % 2 != 0) throw new Exception();
        if (pobi.size() != 2 || crong.size() != 2) throw new Exception();
    }

    // 왼쪽, 오른쪽 페이지 합최대 구하기
    public static int getMaxSum(List<Integer> list) {
        int leftPage = list.get(0);
        int leftSum = 0;
        while(leftPage > 0) {
            leftSum += leftPage%10;
            leftPage /= 10;
        }

        int rightPage = list.get(1);
        int rightSum = 0;
        while(rightPage > 0) {
            rightSum += rightPage%10;
            rightPage /= 10;
        }

        return Math.max(leftSum, rightSum);
    }

    // 왼쪽, 오른쪽 페이지 곱최대 구하기
    public static int getMaxMul(List<Integer> list) {
        int leftPage = list.get(0);
        int leftMul = 1;
        while(leftPage > 0) {
            leftMul *= leftPage%10;
            leftPage /= 10;
        }

        int rightPage = list.get(1);
        int rightMul = 0;
        while(rightPage > 0) {
            rightMul *= rightPage%10;
            rightPage /= 10;
        }

        return Math.max(leftMul, rightMul);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        try {
            inputException(pobi, crong);
        } catch (Exception e) {
            return -1;
        }

        int pobiMaxScore = Math.max(getMaxSum(pobi), getMaxMul(pobi));
        int crongMaxScore = Math.max(getMaxSum(crong), getMaxMul(crong));

        if(pobiMaxScore > crongMaxScore) answer = 1;
        if(crongMaxScore > pobiMaxScore) answer = 2;

        return answer;
    }
}