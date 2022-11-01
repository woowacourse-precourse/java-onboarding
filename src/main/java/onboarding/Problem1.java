package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 페이지가 예외 범위라면 -1 리턴
        if (checkPage(pobi) || checkPage(crong)) return -1;

        List<Integer> pobiMax = new ArrayList<>(); // 포비 최댓값
        pobiMax.add(maxSum(pobi));
        pobiMax.add(multiplication(pobi));
        List<Integer> crongMax = new ArrayList<>(); // 크롱 최댓값
        crongMax.add(maxSum(crong));
        crongMax.add(multiplication(crong));

        if (Collections.max(pobiMax) > Collections.max(crongMax)) return 1;
        if (Collections.max(crongMax) > Collections.max(pobiMax)) return 2;
        if (Collections.max(pobiMax) == Collections.max(crongMax)) return 0;

        return answer;
    }

    // 페이지 유효성 범위 확인
    public static boolean checkPage(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        if (left == 1 || right == 400 || right - left != 1)
            return true;

        return false;
    }

    // 왼쪽, 오른쪽을 받아서 각 자리를 더하고, 더한 값 중 최댓값 return
    public static int maxSum(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);
        int leftSum = 0; // 왼쪽 페이지 더한 값
        int rightSum = 0; // 오른쪽 페이지 더한 값

        while (left != 0) { // 왼쪽 페이지
            leftSum += left % 10;
            left /= 10;
        }

        while (right != 0) { // 오른쪽 페이지
            rightSum += right % 10;
            right /= 10;
        }

        if (leftSum > rightSum) {
            return leftSum; // 왼쪽이 더 크면 왼쪽 반환
        } else
            return rightSum; // 오른쪽이 더 크면 오른쪽 반환
    }

    // 왼쪽, 오른쪽을 받아서 각 자리를 곱하고, 곱한 값 중 최댓값 return
    public static int multiplication(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);
        int leftMulti = 0; // 왼쪽 페이지 더한 값
        int rightMulti = 0; // 오른쪽 페이지 더한 값

        for (int i = 0; i <= left; i++) { // 왼쪽 페이지
            int hun = (i % 1000) / 100; // 백의 자리
            int ten = (i % 100) / 10; // 십의 자리
            int one = i % 10; // 일의 자리
            if (hun == 0) {
                leftMulti = ten * one;
            } else
                leftMulti = hun * ten * one;
        }
        for (int i = 0; i <= right; i++) { // 오른쪽 페이지
            int hun = (i % 1000) / 100; // 백의 자리
            int ten = (i % 100) / 10; // 십의 자리
            int one = i % 10; // 일의 자리
            if (hun == 0) {
                rightMulti = ten * one;
            } else
                rightMulti = hun * ten * one;
        }
        if (leftMulti > rightMulti) {
            return leftMulti; // 왼쪽이 더 크면 왼쪽 반환
        } else
            return rightMulti; // 오른쪽이 더 크면 오른쪽 반환
    }

    public static int pobiMax(List<Integer> list) {
        int pobiLeft = list.get(0);
        int pobiright = list.get(1);

        if (pobiLeft > pobiright) {
            return pobiLeft;
        } else
            return pobiright;
    }

    public static int crongMax(List<Integer> list) {
        int crongLeft = list.get(0);
        int crongright = list.get(1);

        if (crongLeft > crongright) {
            return crongLeft;
        } else
            return crongright;
    }
}