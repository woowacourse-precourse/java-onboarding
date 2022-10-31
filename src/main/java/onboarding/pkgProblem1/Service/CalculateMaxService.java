package onboarding.pkgProblem1.Service;

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
        int[] leftArray, rightArray;

        leftArray = SplitNumber(userPage.get(0));
        rightArray = SplitNumber(userPage.get(1));

        return 0; //CalculateMax(leftArray, rightArray);
    }


    /**
     * 각 자리수 계산을 위해 page 번호를 각 자리수로 나눠 배열에 저장하는 메소드
     * @param page - 하나의 페이지 번호
     * @return 각 자리수를 int[]의 각 인덱스에 저장 후 Return
     */
    public int[] SplitNumber(int page) {
        return Stream.of(String.valueOf(page).split("")).mapToInt(Integer::parseInt).toArray();
    }
}
