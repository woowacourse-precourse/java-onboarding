package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    //pobi와 crong의 길이는 2이다.
    //pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //유효성 체크
        try {
            validatePages(pobi);
            validatePages(crong);
        } catch (IllegalArgumentException e) {
            return -1;
        }

        // 왼쪽, 오른쪽 페이지로 만들 수 있는 숫자 만들기
        int pobiLeftMakeNum = returnMaxNumBetweenMultiplicationAndAddition(pobi.get(0));
        int pobiRightMakeNum = returnMaxNumBetweenMultiplicationAndAddition(pobi.get(1));
        int crongLeftMakeNum = returnMaxNumBetweenMultiplicationAndAddition(crong.get(0));
        int crongRightMakeNum = returnMaxNumBetweenMultiplicationAndAddition(crong.get(1));

        // 만든 수 중 가장 큰 수 찾기
        int pobiMaxNum = returnMaxNum(pobiLeftMakeNum, pobiRightMakeNum);
        int crongMaxNum = returnMaxNum(crongLeftMakeNum, crongRightMakeNum);

        // 가장 큰 수를 찾은 것 중 비교하여 결과값 return
        return compareNums(pobiMaxNum, crongMaxNum);
    }

    public static int returnMaxNumBetweenMultiplicationAndAddition(int page) {
        ArrayList<Integer> pageNums = dividePages(page);

        int multipleNums = multiplyPages(pageNums);
        int addNums = addPages(pageNums);

        // 더 큰 수를 return
        return returnMaxNum(multipleNums, addNums);
    }

    //페이지의 각 자리수를 ArrayList에 담아서 반환
    public static ArrayList<Integer> dividePages(int page) {
        // 각 자리의 페이지 수를 저장할 ArrayList 생성
        // page가 한 자리수, 두 자리 수, 세 자리수가 될 수 있기 때문에 크기가 가변적으로 변하는 ArrayList 사용
        ArrayList<Integer> pageNums = new ArrayList<Integer>();

        while (page > 0) {
            // page값의 각 자리수를 pageNums에 저장
            pageNums.add(page % 10);
            // page값을 계속 page를 10으로 나눈 몫으로 바꾸어주어 자릿수에 맞게 반복문이 실행되도록 설정
            page = page / 10;
        }

        return pageNums;
    }

    // 각 페이지 숫자를 곱한 값을 반환
    public static int multiplyPages(ArrayList<Integer> pageNums) {
        int multipleNums = 1;

        for (int num : pageNums) {
            multipleNums *= num;
        }

        return multipleNums;
    }

    // 각 페이지 숫자를 더한 값을 반환
    public static int addPages(ArrayList<Integer> pageNums) {
        int addNums = 0;

        for (int num : pageNums) {
            addNums += num;
        }

        return addNums;
    }

    public static int returnMaxNum(int num1, int num2) {
        return (num1 > num2) ? num1 : num2;
    }

    public static int compareNums(int pobi, int crong) {
        if (pobi == crong) return 0;
        else if (pobi > crong) return 1;
        else return 2;
    }

    public static void validatePages(List<Integer> page) {
        int leftPage = page.get(0);
        int rightPage = page.get(1);

        // 페이지개수가 2가 아닐 때
        if (page.size() != 2) {
            throw new IllegalArgumentException("두 페이지를 입력해주세요!");
        }

        //왼쪽은 홀수, 오른쪽은 짝수 페이지가 아닐 때
        if (leftPage % 2 != 1 && rightPage % 2 != 0) {
            throw new IllegalArgumentException("왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수로 입력해주세요!");
        }

        //오른쪽 짝수 페이지가 왼쪽 홀수 페이지의 다음 페이지가 아닐 때
        if (rightPage - leftPage != 1) {
            throw new IllegalArgumentException("연속된 페이지를 입력해주세요!");
        }

        //페이지가 시작 면이나 마지막 면일 때
        if (leftPage == 1) {
            throw new IllegalArgumentException("페이지가 시작면 입니다!");
        }

        if (rightPage == 400) {
            throw new IllegalArgumentException("페이지가 마지막면 입니다.!");
        }

        //페이지 범위가 1~400 페이지가 아닐 때
        if (leftPage < 1 || leftPage > 399) {
            throw new IllegalArgumentException("페이지 범위를 1~400로 지정해주세요!");
        }

        if (rightPage < 2 || rightPage > 400) {
            throw new IllegalArgumentException("페이지 범위를 1~400로 지정해주세요!");
        }
    }
}