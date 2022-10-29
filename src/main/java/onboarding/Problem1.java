package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        highestScore(pobi.get(0));
        return answer;
    }

    public static int highestScore(int book){

        int addscore=0;
        int multiplyscore=1;
        int maxscore =0;
        String strbook = Integer.toString(book);
        for (int i = 0; i < strbook.length(); i++) {
            addscore+=book%10;
            multiplyscore*=book%10;
            book = book/10;
        }
        maxscore = Math.max(addscore, multiplyscore);
        System.out.println("addscore : " + addscore + " multiplyscore : " + multiplyscore + " maxscore : " + maxscore);

        return maxscore;
    }

    public static boolean bookValidation(List<Integer> book){
        if(book.size()!=2||book.get(1)-book.get(0)!=1){
            return false;
        }
        if(book.get(0)==1 || book.get(0)==399){
            return false;
        }
        return true;

    }

}