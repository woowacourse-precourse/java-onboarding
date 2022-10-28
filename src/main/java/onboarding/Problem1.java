package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //유효성 검사
        if(!validData(pobi, crong)) return -1;

        //포비 왼쪽 페이지 각 자리수 더하기 or 곱하기
        int pobiScore = getMaxScore(pobi);
        int crongScore = getMaxScore(crong);


        if (pobiScore > crongScore){
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        }else {
            answer = 0;
        }
        return answer;
    }

    /**
     * 왼쪽 페이지가 1보다 작은지, 오른쪽 페이지가 400보다 큰지
     * 왼쪽 페이지가 홀수 인지, 오른쪽 페이지가 짝수 인지
     * @param pobi
     * @param crong
     * @return
     */
    private static boolean validData(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) < 1 || crong.get(0) < 1 || pobi.get(1) > 400 || crong.get(1) > 400) return false;
        if (pobi.get(0) %2 != 1 || crong.get(0) %2 != 1 || pobi.get(1) %2 != 0 || crong.get(1) %2 != 0) return false;
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) return false;
        return true;
    }

    /**
     * 왼쪽 페이지와 오른쪽 페이지에서 가장 조건에 맞는 가장 큰 값 구하기
     * @param pages
     * @return
     */
    private static int getMaxScore(List<Integer> pages) {
        int leftPageSize = (int) Math.log10(pages.get(0)) + 1;
        int rightPageSize = (int) Math.log10(pages.get(1)) + 1;
        int rightPage = pages.get(1);
        int leftPage = pages.get(0);
        return Math.max(getScore(leftPage, leftPageSize), getScore(rightPage, rightPageSize));
    }

    /**
     * 각 자리수를 더한 것과 곱한 것 중 더 큰 값 구히기
     * @param page
     * @param pageSize
     * @return
     */
    private static int getScore(int page, int pageSize){
        int sum = 0;
        int temp = page;
        for (int i = 0; i < pageSize; i++){
            sum += temp%10;
            temp /= 10;
        }

        int duplicate = 1;
        temp = page;
        for (int i = 0; i < pageSize; i++){
            duplicate *= temp%10;
            temp /= 10;
        }

        return Math.max(sum, duplicate);
    }
}