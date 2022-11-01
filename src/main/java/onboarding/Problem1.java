package onboarding;

import java.util.*;

class Problem1 {
    private static int sum;
    private static int Biggest;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return whoseBiggest(pobi, crong);
    }

    private static <pobi, crong> int whoseBiggest(List<Integer> pobi, List<Integer> crong){
        Biggest=(error(pobi)||error(crong)) ? EXCEPTION:
                (myBiggest(pobi)<myBiggest(crong)) ? 2: (myBiggest(pobi)>myBiggest(crong)) ? 1:0;
        return Biggest;
    }

    private static int myBiggest(List<Integer> paper){
        int paper_left=Math.max(add(paper.get(0)), multi(paper.get(0)));
        int paper_right=Math.max(add(paper.get(1)), multi(paper.get(1)));
        Biggest=Math.max(paper_left, paper_right);
        return Biggest;
    }

    private static int add(int page){
        sum=0;
        while(page!=0){
            sum+=page%10;
            page/=10;
        }
        return sum;
    }

    private static int multi(int page){
        sum=1;
        while(page!=0){
            sum*=page%10;
            page/=10;
        }
        return sum;
    }

    private static boolean error(List<Integer> paper) {
        if (paper.get(0) == paper.get(1) - 1 && paper.get(0) % 2 == 1 && paper.get(1) <= 400 && paper.get(0) > 0 && paper.size() == 2) {
            return false;
        }
        return true;
    }
}