package onboarding;

import java.util.List;
import java.util.Arrays;

class Problem1 {
    static final int minPage = 1; // 최소 페이지 번호
    static final int maxPage = 400; // 최대 페이지 번호
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        // 예외 처리
        if (pageExcept(pobi) && pageExcept(crong)) {
            int pobiNum = pageCal(pobi); // 포비의 최대값
            int crongNum = pageCal(crong); // 크롱의 최대값

            if (pobiNum < crongNum) {
                answer = 2;
                return answer;
            }
            if (pobiNum == crongNum) {
                answer = 0;
                return answer;
            }
            return 1;
        }

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

        Arrays.sort(pageNumArr);
        maxNum = pageNumArr[pageNumArr.length - 1];

        return maxNum;
    }

    // 페이지 예외처리
    public static boolean pageExcept(List<Integer> pageLst) {
        int fstNum = pageLst.get(0).intValue();
        int scdNum = pageLst.get(1).intValue();

        return minPage < fstNum && maxPage > fstNum &&
                minPage < scdNum && maxPage > scdNum &&
                fstNum % 2 == 1 && scdNum % 2 == 0 &&
                scdNum - fstNum == 1;
    }

    // 해당 페이지의 자릿수를 모두 더한 값을 리턴
    public static int pageSum(int page) {
        int sum = 0;

        while(page > 0){
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    // 해당 페이지의 자릿수를 모두 곱한 값을 리턴
    public static int pageMul(int page) {
        int mul = 1;

        while(page > 0){
            mul *= page % 10;
            page /= 10;
        }
        return mul;
    }
}