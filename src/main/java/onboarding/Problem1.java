/*
 * Problem1
 *
 * v1.2
 *
 * 2022.10.31
 *
 * 저작권 주의
 */

package onboarding;

import java.util.List;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);


        if(checkPageCorrect(pobiLeftPage, pobiRightPage) && checkPageCorrect(crongLeftPage, crongRightPage)){

            int pobiMax= Math.max(CompareMultAndAdd(pobiLeftPage), CompareMultAndAdd(pobiRightPage));
            int crongMax= Math.max(CompareMultAndAdd(crongLeftPage), CompareMultAndAdd(crongRightPage));

            return compareReturnAnswer(pobiMax, crongMax);
        }else{
            return (-1);
        }

    }


    static boolean checkPageCorrect(int leftPage, int rightPage) {
        return ((leftPage>1 && rightPage<400) && (rightPage-leftPage==1) && (leftPage % 2 ==1));
    }


    static int CompareMultAndAdd(int pageNum){
        int sumNum=0;
        int mulNum=1;
        int [] arr= NumAndArray.makeNumToArray(pageNum);

        for (int i : arr) {
            sumNum += i;
            mulNum *= i;
        }
        ;
        return Math.max(sumNum, mulNum);
    }

    static int compareReturnAnswer(int pobi,int crong){
        if(pobi>crong){
            return 1;
        }else if(pobi<crong){
            return 2;
        }
        return 0;
    }

}
class NumAndArray{
    static int[] makeNumToArray(int number) {
        String string = Integer.toString(number);
        int [] array = new int[string.length()];
        for (int i=0; i<string.length(); i++ ){
            array[i] = string.charAt(i) - '0';
        }
        return array;
    }

}