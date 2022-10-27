package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_MaxVal=0;
        int crong_MaxVal=0;

        if(isException(pobi.get(0),pobi.get(1))||isException(crong.get(0),crong.get(1))){
            answer=-1;
        }else {

        }

        return answer;
    }

    static boolean isException(int leftPage ,int rightPage){
        if(leftPage>rightPage){
            return true;
        }
        else if(rightPage-leftPage!=1){
            return true;
        }
        else if(leftPage<1||rightPage>400){
            return true;
        }
        else return false;
    }

    static int PageCheck(int page){
        int MAX_PAGE_ADD =0;
        int MAX_PAGE_MUL =1;

        while(page!=0){
            MAX_PAGE_ADD+=page%10;
            MAX_PAGE_MUL*=page%10;
            page/=10;
        }
        return Math.max(MAX_PAGE_ADD,MAX_PAGE_MUL);
    }
}