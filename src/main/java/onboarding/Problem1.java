package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int Maxsum(Integer leftPage, Integer rightPage){
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



}