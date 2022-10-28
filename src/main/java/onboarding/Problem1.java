package onboarding;

import java.io.IOException;
import java.util.List;


class Problem1 {
   public static final int LISTSIZE = 2;
   public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        try {
            exception(pobi);
            exception(crong);
            int pobiMaxNum = maxNumber(pobi);
            int crongMaxNum = maxNumber(crong);

            answer = winner(pobiMaxNum,crongMaxNum);
        }catch (IOException | RuntimeException e){
            answer = -1;
        }

       return answer;
    }

    public static int maxNumber(List<Integer>someone){
        int MaxsumPageNumber = maxSumPageNumber(someone);
        int MaxmultiPageNumber = maxmultipage(someone);

        return Math.max(MaxsumPageNumber,MaxmultiPageNumber);
    }


    public static int maxSumPageNumber(List<Integer>someone){
        int leftPageSum = 0;
        int leftpage = someone.get(0);
            while(leftpage != 0) {
                leftPageSum += leftpage % 10;
                leftpage /= 10;
            }
        int rightPageSum = 0;
        int rightpage = someone.get(1);
            while(rightpage != 0) {
                rightPageSum += rightpage % 10;
                rightpage /= 10;
            }
        return Math.max(leftPageSum,rightPageSum);
   }

   public static int maxmultipage(List<Integer>someone){
       return Math.max(multiLeftpage(someone.get(0)), multiRightpage(someone.get(1)));
   }

    public static int multiLeftpage(Integer pageNum){
        int multiLeftpage = 1;
        String page = String.valueOf(pageNum);
        if(page.length()>=2){
            for(int i = 0; i<page.length(); i++){
            multiLeftpage *= Integer.parseInt(page.substring(i,i+1));
            
            }
        }else{
            multiLeftpage = pageNum;
        }
        return multiLeftpage;
    }
    public static int multiRightpage(Integer pageNum){
        int multiRightpage = 1;
        String page = String.valueOf(pageNum);
        if(page.length()>=2){
            for(int i = 0; i<page.length(); i++){
                multiRightpage *= Integer.parseInt(page.substring(i,i+1));
                multiRightpage /=10;

            }
        }else {
            multiRightpage = pageNum;
        }
        return multiRightpage;
    }

    public static int winner(int pobiMaxNum, int crongMaxNum){
        int winner = 0;
        if(pobiMaxNum > crongMaxNum){
            winner = 1;
        }
        if(pobiMaxNum < crongMaxNum){
            winner = 2;
        }
        return winner;

    }

    public static void exception(List<Integer>someone) throws IOException{
        for(int i = 0; i<LISTSIZE; i++){
        if((someone.get(1) - someone.get(0)) != 1){
            throw new IOException();
        }
        if(someone.get(0)==1 || someone.get(1)==400 ){
            throw new IOException();
        }
        }

    }

}