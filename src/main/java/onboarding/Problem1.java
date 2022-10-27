package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. 첫번째 페이지 혹은 마지막 페이지가 매개변수로 들어오면 -1을 리턴한다.
 * 2. 포비와 크롱의 각자리 숫자를 구한다.
 * 2-1. 포비와 크롱의 왼쪽의 각자리 숫자와 오른쪽 각자리 숫자 배열을 list에 저장한다.
 * 3. 포비와 크롱의 각자리 숫자를 더하거나 곱하여 큰수를 구한다.
 * 4. 포비와 크롱의 큰 수끼리 비교한다.
 * 5. 포비의 숫자가 크면 1을 리턴한다.
 * 6. 크롱의 숫자가 크면 2를 리턴한다.
 * 7. 무승부면 0을 리턴한다.
 * 8. 예외사항은 -1을 리턴한다.
 */
class Problem1 {

    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (validateFirstLast(pobi) || validateFirstLast(crong)) {
            return -1;
        } else if (validatePlusOne(pobi) || validatePlusOne(crong)) {
            return -1;
        } else if (validateEvenAndOdd(pobi) || validateEvenAndOdd(crong)) {
            return -1;
        }

        List<Integer> pobiEachNumbers = getEachDigitNumber(pobi);
        List<Integer> crongEachNumbers = getEachDigitNumber(crong);

        List<int[]> pobiEachListLeftAndRight = getEachListLeftAndRight(pobiEachNumbers);
        List<int[]> crongEachListLeftAndRight = getEachListLeftAndRight(crongEachNumbers);

        int pobiBigNumber = getBigNumber(pobiEachListLeftAndRight);
        int crongBigNumber = getBigNumber(crongEachListLeftAndRight);

        answer = retrunBigNumber(pobiBigNumber, crongBigNumber);

        return answer;

    }

    private static boolean validateEvenAndOdd(List<Integer> check) {
        return !(check.get(0) % 2 == 1 && check.get(1) % 2 == 0);
    }

    private static boolean validatePlusOne(List<Integer> check) {
        return !(check.get(1) == check.get(0) + 1);
    }

    private static int retrunBigNumber(int pobiBigNumber, int crongBigNumber) {
        if (pobiBigNumber > crongBigNumber) {
            return 1;
        } else if (pobiBigNumber < crongBigNumber) {
            return 2;
        } else {
            return 0;
        }
    }

    private static int getBigNumber(List<int[]> eachListLeftAndRight) {
        int[] left = eachListLeftAndRight.get(0);
        int[] right = eachListLeftAndRight.get(1);
        int leftSum = 0;
        int leftMultiplicationSum = 1;
        int rightSum = 0;
        int rightMultiplicationSum = 1;

        List<Integer> allList = new ArrayList<>();

        for (int i = 0; i < left.length; i++) {
            leftSum += left[i];
            leftMultiplicationSum *= left[i];
            rightSum += right[i];
            rightMultiplicationSum *= right[i];
        }

        allList.add(leftSum);
        allList.add(leftMultiplicationSum);
        allList.add(rightSum);
        allList.add(rightMultiplicationSum);

        return Collections.max(allList);
    }

    private static List<int[]> getEachListLeftAndRight(List<Integer> eachNumbers) {
        int halfNumber = eachNumbers.size() / 2;
        int[] left = new int[halfNumber];
        int[] right = new int[halfNumber];
        List<int[]> eachListLeftAndRight = new ArrayList<>();


        for (int i = 0; i < halfNumber; i++) {
            left[i] = eachNumbers.get(i);
        }

        for (int i = halfNumber; i < eachNumbers.size(); i++) {
            right[i - halfNumber] = eachNumbers.get(i);
        }

        eachListLeftAndRight.add(left);
        eachListLeftAndRight.add(right);
        return eachListLeftAndRight;
    }


    private static List<Integer> getEachDigitNumber(List<Integer> getEach) {
        int num;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < getEach.size(); i++) {
            num = getEach.get(i);
            while (num > 0) {
                list.add(num % 10);
                num /= 10;
            }
        }

        return list;
    }

    public static boolean validateFirstLast(List<Integer> checkList) {
        return checkList.contains(FIRST_PAGE) || checkList.contains(LAST_PAGE);
    }
}