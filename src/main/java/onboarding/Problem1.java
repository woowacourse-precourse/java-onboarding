package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        try{
            checkLength(pobi,crong);
            int pobiScore = getPageBestScore(pobi);
            int crongScore = getPageBestScore(crong);

            answer = getWinner(pobiScore, crongScore);
        } catch (Exception e){
            answer=-1;
        }
        return answer;
    }

    public static int getPageBestScore(List<Integer> list) throws Exception {
        int left = list.get(0);
        int right = list.get(1);

        checkPages(left,right);
        checkPageRange(left);
        checkPageRange(right);
        if (isOdd(left)&&isEven(right)){
            return Math.max(getScore(left),getScore(right));
        }else {
            throw new Exception("홀수 짝수가 지켜지지 않음");
        }
    }

    public static int getScore(int page){
        return Math.max(sumMaxValue(page),mulMaxValue(page));
    }

    public static int sumMaxValue(int page){
        int sum=0;
        while (page>0){
            sum += page % 10;
            page /=10;
        }
        return sum;
    }

    public static int mulMaxValue(int page){
        int mul=1;
        while (page>0){
            mul*=page%10;
            page=page/10;
        }
        return mul;
    }



    public static void checkLength(List<Integer> pobi,List<Integer> crong) throws Exception{
        if (pobi.size()!=2||crong.size()!=2) throw new Exception("페이지 불일치");
    }
    public static void checkPages(int left,int right) throws Exception {
        if (right-left!=1) throw new Exception ("페이지는 1차이어야 합니다.");
    }

    public static boolean isEven(int page){
        if (page%2==0) return true;
        else return false;
    }

    public static boolean isOdd(int page){
        if (!isEven(page)) return true;
        else return false;
    }

    public static void checkPageRange(int page) throws Exception{
        if(page<1||page>400) throw new Exception("페이지 범위 초과");
    }

    public static int getWinner(int pScore,int cScore){
        int winner = 0;
        if (pScore>cScore) winner=1;
        else if (cScore>pScore) winner=2;
        return winner;
    }
}