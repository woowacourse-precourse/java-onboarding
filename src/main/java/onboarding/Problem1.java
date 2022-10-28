package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    private static int calMaxPageNum(int page) {
        String pageToString = String.valueOf(page);

        int addSum=0;
        int mulSum=1;
        for (int i = 0; i < pageToString.length(); i++) {
            addSum += pageToString.charAt(i)-'0';
            mulSum*= pageToString.charAt(i)-'0';
        }

        return Math.max(addSum, mulSum);
    }

    private static boolean isIncludePage(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if(pages.size()!=2) return false;
        else if(leftPage>rightPage) return false;
        else if(leftPage<=1||leftPage>=400||rightPage<=1||rightPage>=400) return false;  //시작면과 마지막면 포함하지 않기위해 '=' 사용
        else if(leftPage%2!=1||rightPage%2!=0) return false;
        else if(rightPage-leftPage!=1) return false;
        else return true;
    }
}