package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PageList {
    private List<Integer> pages;

    public PageList(final List<Integer> integerList) {
        validatePages(integerList);
        this.pages = integerList;
    }

    public List<Integer> getPages() {
        return this.pages;
    }

    public void validatePages(List<Integer> integerList) {
        /* pageList의 길이 = 2 */
        if (integerList.size() != 2) {
            throw new IllegalArgumentException(String.format("A Size of pages should be 2"));
        }
        /* left는 홀수, right는 짝수 */
        if (integerList.get(0) % 2 != 1 | integerList.get(1) % 2 != 0) {
            throw new IllegalArgumentException(String.format("A pages should be in order of odd and even page number"));
        }
        /* 페이지는 연속된 값 */
        if (integerList.get(1) - integerList.get(0) != 1) {
            throw new IllegalArgumentException(String.format("A pages should be composed of sequential page"));
        }
        /* 1 <= left page <= 399 and 2 <= right page <= 400 */
        if (integerList.get(0) < 1 | integerList.get(0) > 399 | integerList.get(1) < 2 | integerList.get(1) > 400) {
            throw new IllegalArgumentException(String.format("The number of pages must be between 1 and 400"));
        }
    }
}

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        /* 예외 사항 */
        PageList pobiPages;
        PageList crongPages;
        try {
            pobiPages = new PageList(pobi);
            crongPages = new PageList(crong);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();    // 오류 출력
            return -1;
        }

        /* 점수 목록 */
        List<Integer> scoresPobi = merge(mapToSum(pobiPages.getPages()), mapToMul(pobiPages.getPages()));
        List<Integer> scoresCrong = merge(mapToSum(crongPages.getPages()), mapToMul(crongPages.getPages()));

        /* 최대 점수 */
        int maxPobi = Collections.max(scoresPobi);
        int maxCrong = Collections.max(scoresCrong);

        /* 결과 반환 */
        if (maxPobi < maxCrong) {   // crong이 pobi보다 점수가 높으면
            return 2;
        }
        if (maxPobi > maxCrong) {   // pobi가 crong보다 점수가 높으면
            return 1;
        }
        return 0;   // pobi와 crong의 점수가 같은 경우
    }

    static int sumNumberByDigit(int number) {
        /* 정수 number 가 주어졌을 때 자리수(digit)별 숫자의 합을 return */
        int sum = 0;
        while (number != 0) {
            sum += number % 10;   // number 를 10으로 나눈 나머지(자리수 숫자)를 sum 에 더한다.
            number /= 10;   // number 를 10으로 나눈 몫을 number 에 저장한다.
        }
        return sum;
    }

    static int mulNumberByDigit(int number) {
        /* 숫자 number 가 주어졌을 때 자리수(digit)별 숫자의 곱을 return */
        int mul = 1;
        while (number != 0) {
            mul *= number % 10;   // number 를 10으로 나눈 나머지(자리수 숫자)를 mul 에 곱한다.
            number /= 10;   // number 를 10으로 나눈 볷을 number 에 저장한다.
        }
        return mul;
    }

    static List<Integer> mapToSum(List<Integer> intList) {
        List<Integer> sumList = new ArrayList<>(intList);
        sumList.replaceAll(i -> sumNumberByDigit(i));
        return sumList;
    }

    static List<Integer> mapToMul(List<Integer> intList) {
        List<Integer> mulList = new ArrayList<>(intList);
        mulList.replaceAll(i -> mulNumberByDigit(i));
        return mulList;
    }

    static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        merged.addAll(list1);
        merged.addAll(list2);
        return merged;
    }

    ;
}