package onboarding;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        try {
            exception(pobi.get(1),pobi.get(0));
            exception(crong.get(1),crong.get(0));
            int pobiMaxNum = maxNumber(pobi.get(0),pobi.get(1));
            int crongMaxNum = maxNumber(crong.get(0), crong.get(1));

            answer = winner(pobiMaxNum,crongMaxNum);
        }catch (IOException e){
            answer = -1;
        }

        return answer;
    }

    public static int maxNumber(Integer leftPage, Integer rightPage){
        int maxNumber = 0;
        int maxMulti = Math.max(multiLeftpage(leftPage),multiRightpage(rightPage));
        int maxSum = Math.max(sumLeftPage(leftPage),sumRightpage(rightPage));

        return maxNumber = Math.max(maxMulti,maxSum);
    }


    public static int sumLeftPage(Integer pageNum){
        int sumLeftPage = 0;
        while (pageNum != 0){
            sumLeftPage += pageNum%10;
            pageNum /= 10;
        }return  sumLeftPage;
    }



    public static int sumRightpage(Integer pageNum){
        int sumRightPage = 0;
        while (pageNum != 0){
            sumRightPage += pageNum%10;
            pageNum /= 10;
        }return  sumRightPage;
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
        }else if(pobiMaxNum < crongMaxNum){
            winner = 2;
        }else if (pobiMaxNum == crongMaxNum){
            winner = 0;
        }
        return winner;

    }

    public static int exception(Integer leftPageNum, Integer rightPageNum) throws IOException{
        int exception = 0;
        if(rightPageNum - leftPageNum != 1){
            exception = -1;
        }
        return exception;
    }



}