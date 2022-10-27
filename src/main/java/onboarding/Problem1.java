package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        int pobiMaxsum = maxSum(pobi.get(0),pobi.get(1));
        int pobiMaxmulti = maxMulti(pobi.get(0),pobi.get(1));
        int pobiMaxNum = Math.max(pobiMaxsum,pobiMaxmulti);

        int crongMaxsum = maxSum(crong.get(0),crong.get(1));
        int crongMaxmulti = maxMulti(crong.get(0), crong.get(1));
        int crongMaxNum = Math.max(crongMaxsum,crongMaxmulti);

        answer = winner(pobiMaxNum,crongMaxNum);



        return answer;
    }

    public static int maxSum(Integer leftPage, Integer rightPage){
        int Maxsum = Math.max(sumLeftPage(leftPage),sumRightpage(rightPage));

        return Maxsum;
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

    public static int maxMulti(Integer leftPage, Integer rightPage){
        int maxMulti = Math.max(multiLeftpage(leftPage),multiRightpage(rightPage));
        return maxMulti;
    }

    public static int multiLeftpage(Integer pageNum){
        int multiLeftpage = 0;
        String page = String.valueOf(pageNum);

        for(int i = 0; i<page.length();i++){
            multiLeftpage *=Integer.parseInt(page.substring(i,i+1));
        }
        return multiLeftpage;
    }
    public static int multiRightpage(Integer pageNum){
        int multiRightpage = 0;
        String page = String.valueOf(pageNum);

        for(int i = 0; i<page.length();i++){
            multiRightpage *=Integer.parseInt(page.substring(i,i+1));
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
        if (pobiMaxNum == crongMaxNum){
            winner = 0;
        }
        return winner;

    }



}