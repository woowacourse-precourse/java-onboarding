package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem1_re {


    public static void main(String[] args){

        int page = 128;

    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        //유효성 검사
        answer = validate(pobi) + validate(crong);
        if(answer <= -1) {return answer;}

        return answer;
    }



    public static int validate(List<Integer> pages) {
        try{
            for (int p : pages){checkPageSize(p);}
            checkNextPage(pages);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return 0;
    }


    public static void checkPageSize(int p) {
        if (p <=0 || p >= 401) { throw new IllegalArgumentException("[ERROR] 1~400페이지만 유효함."); }
    }

    public static void checkNextPage(List<Integer> pages) {
        if (pages.get(0) != pages.get(1)-1){throw new IllegalArgumentException("[ERROR] 같은 장의 페이지가 아님.");}
    }

    public static int maxNum(int page) {
        List<Integer> left = new ArrayList<>(List.of(add(page),multi(page)));
        List<Integer> right = new ArrayList<>(List.of(add(page +1),multi(page+1)));
        return 0;
    }

    public static int add(int page) {
        return (page/100) + (page/10 - (page/100)*10) + (page%10);
    }

    public static int multi(int page) {
        return (page/100) * (page/10 - (page/100)*10) * (page%10);
    }

}
