package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(input_exception(pobi)||input_exception(crong)) return -1;
        int pobi_max=getMaxScore(pobi);
        int crong_max=getMaxScore(crong);

        return getWinner(pobi_max,crong_max);
    }

    private static int getMaxScore(List<Integer> bookList){
        int left_page = bookList.get(0);
        int right_page = bookList.get(1);
        int left_score = getScore(left_page);
        int right_score = getScore(right_page);

        if(left_score>right_score) return left_score;
        else return right_score;
    }

    private static int getScore(int page){
        int sum_score=getSumScore(page);
        int multi_score=getMultiScore(page);

        if(sum_score>multi_score) return sum_score;
        else return multi_score;
    }

    private static int getSumScore(int page){
        ArrayList<Integer> divided_page=new ArrayList<>();
        int result=0;

        while(page!=0){
            divided_page.add(page%10);
            page=page/10;
        }
        for (int i: divided_page){
            result+=i;
        }
//        System.out.println("getSumScore"+result);
        return result;
    }

    private static int getMultiScore(int page){
        ArrayList<Integer> divided_page=new ArrayList<>();
        int result=1;

        while(page!=0){
            divided_page.add(page%10);
            page=page/10;
        }
        for (int i: divided_page){
            result*=i;
        }
//        System.out.println("getMultiScore"+result);
        return result;
    }

    private static int getWinner(int former,int latter){
//        System.out.println(former+", "+latter);
        if(former>latter) return 1;
        else if(former<latter) return 2;
        else if(former==latter) return 0;
        return -1;
    }

    private static boolean input_exception(List<Integer> input){
        //true is 'exception excution'
        if(input.get(1)<3||input.get(0)>398) return true;
        if((input.get(1)-input.get(0))!=1) return true;
        return false;
    }
}