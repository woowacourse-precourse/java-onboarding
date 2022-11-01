package onboarding;

import java.util.List;
/*
기능목록
1. 페이지 규칙 확인하는 기능
    1-1. 시작면이나 마지막 면이 나오는 경우X
    1-2. 왼쪽 오른쪽 페이지의 차이가 1인지
2. 페이지별 최대 점수 구하는 기능
    2-1. 모두 더한 경우와 모두 곱한 경우 구해서 최대 찾기
3. 오른쪽, 왼쪽 중 최대 기능 구하는 기능
4. 승자 구하는 기능
 */
class Problem1 {
    //페이지 규칙 확인하는 기능
    public static boolean checkPage(Integer left, Integer right){
        if(left>=right){
            return false;
        }
        if(Math.abs(left-right)>1){ //왼쪽 오른쪽 페이지의 차이가 1보다 큰 경우
            return false;
        }
        if(left<=1 || right<=1){ //시작 면인경우
            return false;
        }
        if(right>=400 || left>=400){ //마지막인경우
            return false;
        }
        return true;
    }
    //페이지를 전달인자로 최대 점수 구하는 기능
    public static Integer calcScore(Integer page){
        int plus=0; //모두 더하는 경우
        int multi=1; //모두 곱하는 경우
        while(page>0){
            int num=page%10;
            plus+=num;
            multi*=num;
            page/=10;
        }
        return plus>multi ? plus : multi;
    }

    //오른쪽, 왼쪽 페이지 중에 최대 구하는 기능
    public static Integer MaxPage(List<Integer> pages){
        if (!checkPage(pages.get(0), pages.get(1))){
            return -1;
        }
        int left=calcScore(pages.get(0));
        int right=calcScore(pages.get(1));
        return left>right? left : right;
    }
    //승자 구하는 기능(1: 포비 승/2: 크롱 승/0:무승부/예외 -1)
    public static Integer getWin(List<Integer> pobi, List<Integer> crong){
        int pobiScore=MaxPage(pobi);
        int crongScore=MaxPage(crong);
        if(pobiScore==-1 || crongScore==-1) return -1;
        if (pobiScore>crongScore){
            return 1;
        }else if(pobiScore<crongScore){
            return 2;
        }else if(pobiScore==crongScore){
            return 0;
        }
        return -1;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        answer=getWin(pobi, crong);
        return answer;
    }
}