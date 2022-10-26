package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        return answer;
    }

    // 게임에 참여하는 개인의 페이지 리스트를 매개변수로 받으면 각 자릿수를 계산 후 최대값을 리턴하는 메소드
    public static int pageCal(List<Integer> pageLst){

        int maxNum = 0;
        int[] pageNumArr = new int[4];

        pageNumArr[0] = pageSum(pageLst.get(0)); // 왼쪽 페이지 각 자릿수 모두 더한 값
        pageNumArr[1] = pageMul(pageLst.get(0)); // 왼쪽 페이지 각 자릿수 모두 곱한 값
        pageNumArr[2] = pageSum(pageLst.get(1)); // 오른쪽 페이지 각 자릿수 모두 더한 값
        pageNumArr[3] = pageMul(pageLst.get(1)); // 오른쪽 페이지 각 자릿수 모두 곱한 값

        // 정렬해서 사용한다면 추후에 두, 세 번째로 큰 값을 구해야할 때도 편하게 사용할 수 있음
        Arrays.sort(pageNumArr);
        System.out.println("배열 : " + Arrays.toString(pageNumArr));
        maxNum = pageNumArr[pageNumArr.length - 1];

        return maxNum;
    }

    // 페이지 예외처리
    public static boolean pageExcept(List<Integer> pageLst) {
        if (pageLst.get(0).intValue() % 2 != 1 || pageLst.get(1).intValue() % 2 != 0
                || pageLst.get(1).intValue() - pageLst.get(0).intValue() != 1) {
            return true;
        }
        return false;
    }

    // 페이지를 매개변수로 받으면 해당 페이지의 자릿수를 모두 더한 값을 리턴
    public static int pageSum(int page) {
        int sum = 0;

        while(page > 0){
            sum += page % 10;
            page /= 10;
        }

        return sum;
    }

    // 페이지를 매개변수로 받으면 해당 페이지의 자릿수를 모두 곱한 값을 리턴
    public static int pageMul(int page) {
        int mul = 0;

        while(page > 0){
            mul *= page % 10;
            page /= 10;
        }

        return mul;
    }
}