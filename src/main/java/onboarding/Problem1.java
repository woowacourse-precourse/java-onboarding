package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        try{
            validate(pobi);
        } catch(IllegalArgumentException e){
            return -1;
        }

        return 0;
    }

    //유효한 좌우 페이지인지 확인
    public static void validate(List<Integer> pages){

        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if(leftPage+1 == rightPage)
            return;

        throw new IllegalArgumentException();
    }

}