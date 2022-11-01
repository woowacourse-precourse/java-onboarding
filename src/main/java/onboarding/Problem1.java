package onboarding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



class Problem1 {
    static final int EXECPTION = -1;
    static final int POBIWIN = 1;
    static final int CRONGWIN = 2;
    static final int TIE = 0;

    public static void main(String[] args) {
        List<Integer> pobi = new ArrayList<>();
        pobi.add(97); pobi.add(98);
        List<Integer> crong = new ArrayList<>();
        crong.add(197); crong.add(198);
        System.out.println(solution(pobi,crong));
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(!checkExecption(pobi) || !checkExecption(crong)){
            return EXECPTION;
        }

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);

        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        int pobiLeftScore = returnMax(pobiLeft);
        int pobiRightScore = returnMax(pobiRight);

        int crongLeftScore = returnMax(crongLeft);
        int crongRightScore = returnMax(crongRight);

        int pobiScore = Math.max(pobiLeftScore,pobiRightScore);
        int crongScore = Math.max(crongLeftScore,crongRightScore);

        answer = checkWiner(pobiScore,crongScore);

        return answer;
    }

    public static boolean isOddNumber(int page) {
        return page % 2 == 1;
    }

    public static boolean isEvenNumber(int page) {
        return page % 2 == 0;
    }
    public static  boolean isContinues(int leftPage,int rightPage) {
        return rightPage - 1 == leftPage;
    }
    public static boolean isrange(int leftPage,int rightPage){
        if(leftPage<=1 || rightPage>=400)
            return false;
        return true;
    }
    public static int checkWiner(int pobi,int crong){
        if(pobi>crong) {
            return POBIWIN;
        }else if(pobi<crong){
            return CRONGWIN;
        }else{
            return TIE;
        }
    }
    public static boolean checkExecption(List<Integer> list){
        int leftPage = list.get(0);
        int rightPage = list.get(1);

        return isOddNumber(leftPage) && isEvenNumber(rightPage) &&
                isrange(leftPage,rightPage) && isContinues(leftPage,rightPage);
    }
    public static int returnMax(int num){
        return Math.max(totalSum(num),totalMulti(num));
    }
    public static int totalSum(int num){
        int total = 0;
        while(num>0){
            total += num%10;
            num = num/10;
        }
        return total;
    }
    public static int totalMulti(int num){
        int total = 1;
        while(num>0){
            total *= num%10;
            num = num/10;
        }
        return total;
    }
}