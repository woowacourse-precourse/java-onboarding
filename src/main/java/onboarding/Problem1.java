package onboarding;

import java.util.List;
import static java.lang.Math.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(checkException(pobi.get(0),pobi.get(1)) && checkException(crong.get(0),crong.get(1))){
            answer = whoIsBigger(calculate(pobi.get(0), pobi.get(1)),calculate(crong.get(0),crong.get(1)));
        }
        else{
            answer =-1;
        }
        return answer;
    }
    public static int calculate(Integer leftPage,Integer rightPage){   //왼쪽 오른쪽중 누가 더 큰지
        String left = leftPage.toString();
        String right =rightPage.toString();
        int tmp = max(max(calculateMul(left),calculatePlus(left)),max(calculatePlus(right),calculateMul(right)));
        return tmp;
    }
    public static int calculateMul(String num){ //각자리 곱해주기
       int ans =1;
       for(int i=0;i<num.length();i++){
           ans *= Integer.parseInt(num.substring(i,i+1));
       }
       return ans;
    }
    public static int calculatePlus(String num){ //각 자리 더해주기
        int ans =0;
        for(int i=0;i<num.length();i++){
            ans += Integer.parseInt(num.substring(i,i+1));
        }
        return ans;
    }
    public static int whoIsBigger(Integer pobiNum, Integer crongNum){//서로의 최종 숫자로 비교
        if(pobiNum == crongNum){
            return 0;
        }
        else if(pobiNum >crongNum){
            return 1;
        }
        else{
            return 2;
        }
    }
    public static boolean checkException(Integer leftPage,Integer rightPage){ // 에러처리
        if(checkFirstOrLastPage(leftPage) &&checkFirstOrLastPage(rightPage)){
            if(leftPage +1 != rightPage){
                return false;
            }
            return true;
        }
        return false;
    }
    public static boolean checkFirstOrLastPage(Integer page){//에러 중 페이지 범위 측정
        if(page <=1 ||page >=400){
            return false;
        }
        return true;
    }
}