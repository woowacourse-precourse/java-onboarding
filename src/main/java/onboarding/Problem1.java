package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!bookValidation(pobi)||!bookValidation(crong)){
            return -1;
        }
        int pobiscore = Math.max(highestScore(pobi.get(0)), highestScore(pobi.get(1)));
        int crongscore  = Math.max(highestScore(crong.get(0)), highestScore(crong.get(1)));
        if(pobiscore>crongscore){
            return 1;
        }else if(pobiscore<crongscore){
            return 2;
        }else {
            return 0;
        }
    }

    public static int highestScore(int book){

        int addscore=0;
        int multiplyscore=1;
        int maxscore;
        String strbook = Integer.toString(book);
        for (int i = 0; i < strbook.length(); i++) {
            addscore+=book%10;
            multiplyscore*=book%10;
            book = book/10;
        }
        maxscore = Math.max(addscore, multiplyscore);

        return maxscore;
    }

    public static boolean bookValidation(List<Integer> book){
        if(book.size()!=2||book.get(1)-book.get(0)!=1){
            return false;
        }
        if(book.get(0)<=1 || book.get(1)<2 || book.get(0)>=399 || book.get(1)>400){
            return false;
        }
        return true;

    }

}