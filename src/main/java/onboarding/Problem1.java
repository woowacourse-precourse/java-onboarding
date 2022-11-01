package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!isValid(pobi) || !isValid(crong)){
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        int pobiNum = getMaxNumber(pobi);
        int crongNum = getMaxNumber(crong);
        answer = getWinner(pobiNum, crongNum);

        return answer;
    }

    /**
     * pageNumber의 각 자릿수의 합을 반환
     * */
    public static int getPageNumberSum(Integer pageNumber){
        int ret = 0;
        while(pageNumber>0){
            ret += pageNumber%10;
            pageNumber/= 10;
        }
        return ret;
    }

    /**
     * pageNumber의 각 자릿수들의 곱을 반환
     */
    public static int getPageNumberMul(Integer pageNumber){
        int ret = 1;
        while(pageNumber>0){
            ret *= pageNumber%10;
            pageNumber/=10;
        }
        return ret;
    }

    /**
     * 왼쪽 페이지와 오른쪽 페이지의 각 자리 숫자들의 합과 곱들을 얻고, 그 중 가장 큰 값을 반환
     * @param pages 왼쪽 페이지와 오른쪽 페이지의 숫자가 담긴 리스트
     */
    public static int getMaxNumber(List<Integer> pages){
        int MaxNumber = 0;
        for(Integer pageNumber : pages){
            int sum = getPageNumberSum(pageNumber);
            int mul = getPageNumberMul(pageNumber);
            MaxNumber = max(MaxNumber, sum);
            MaxNumber = max(MaxNumber, mul);
        }
        return MaxNumber;
    }

    /**
     * pobi와 crong의 페이지 펼치기 게임 결과를 반환
     * @param pobiNumber pobi가 페이지를 펼쳐서 얻을 수 있는 가장 큰 숫자
     * @param crongNumber crong이 페이지를 펼쳐서 얻을 수 있는 가장 큰 숫자
     */
    public static int getWinner(int pobiNumber, int crongNumber){
        if(pobiNumber > crongNumber){
            return 1;
        }
        if(crongNumber > pobiNumber){
            return 2;
        }
        return 0;
    }

    /**
     * 왼쪽 페이지 숫자와 오른쪽 페이지 숫자가 유효한지 검사
     * @param pages 오른쪽 페이지와 왼쪽 페이지가 담긴 리스트
     * @return 유효하면 true를 반환, 유효하지 않으면 false를 반환
     */
    public static boolean isValid(List<Integer> pages){
        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);
        if(rightPage - leftPage != 1){
            return false;
        }
        if(pages.get(0)%2 == 0){
            return false;
        }
        if(pages.get(1)%2 != 0){
            return false;
        }
        if(leftPage < 2){
            return false;
        }
        if(rightPage > 399){
            return false;
        }
        return true;
    }

}