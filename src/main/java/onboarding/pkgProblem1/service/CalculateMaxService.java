package onboarding.pkgProblem1.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * User의 pageList를 받아 최대값을 구하는 CalculateMaxSevice
 * @author 유지웅
 */
public class CalculateMaxService {
    /* ---------------- Public operations -------------- */

    /**
     * User의 두 개의 page 번호가 담긴 list를 받아 최대값을 계산하여 return하는 메소드
     * @param userPageList - user의 두 개의 page 번호가 담긴 list
     * @return user page 덧셈, 곱셈 값의 최대값
     */
    public int ReturnMaxScore(List<Integer> userPageList) {
        List<Integer> userPage = userPageList;

        if(Math.abs(userPage.get(0)-userPage.get(1))!=1)  return -1;
        if(userPage.get(0)<=0 || userPage.get(1)>400) return -1;

        int[] leftArray, rightArray;

        leftArray = SplitNumber(userPage.get(0));
        rightArray = SplitNumber(userPage.get(1));



        return CalculateMax(leftArray, rightArray);
    }

    /* ---------------- Private Calculate operations -------------- */
    /**
     * 한 User의 각 페이지를 자리수대로 나눈 Array를 받아 덧셈, 곱셈의 결과에 따른 최대값 반환하는 메소드
     * @param leftPageArray - 왼쪽 페이지의 각 자리수를 담은 Array
     * @param rightPageArray - 오른쪽 페이지의 각 자리수를 담은 Array
     * @return 각 페이지를 곱셈 덧셈하여 나온 최대값을 반환
     */
    private int CalculateMax(int[] leftPageArray, int[] rightPageArray) {
        int sumMax, mulMax;
        int left,right;

        left = CalculateSum(leftPageArray);
        right = CalculateSum(rightPageArray);

        sumMax = left > right ? left : right;

        left = CalculateMul(leftPageArray);
        right = CalculateMul(rightPageArray);

        mulMax = left > right ? left : right;

        return sumMax > mulMax ? sumMax : mulMax;
    }

    /**
     * 한 페이지의 자리수를 모두 더한 값을 Return하는 메소드
     * @param page - 페이지 번호를 각 자리수대로 나누어 놓은 int 배열
     * @return 배열 page에 있는 모든 숫자를 더한 것을 Return
     */
    public int CalculateSum(int[] page) {
        return Arrays.stream(page).sum();
    }

    /**
     * 한 페이지의 자리수를 모두 곱한 값을 Return하는 메소드
     * @param page - 페이지 번호를 각 자리수대로 나누어 놓은 int 배열
     * @return 배열 page에 있는 모든 숫자를 곱한 것을 Return
     */
    public int CalculateMul(int[] page) {
        return Arrays.stream(page).reduce(1, (a, b) -> a * b);
    }

    /**
     * 각 자리수 계산을 위해 page 번호를 각 자리수로 나눠 배열에 저장하는 메소드
     * @param page - 하나의 페이지 번호
     * @return 각 자리수를 int[]의 각 인덱스에 저장 후 Return
     */
    private int[] SplitNumber(int page) {
        return Stream.of(String.valueOf(page).split("")).mapToInt(Integer::parseInt).toArray();
    }
}
