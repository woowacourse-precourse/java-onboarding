package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        try{
            checkLength(pobi,crong);

        } catch (Exception e){
            answer=-1;
        }
        return answer;
    }
    public static void getPageBestScore(List<Integer> list) throws Exception {
        int left = list.get(0);
        int right = list.get(1);

        checkPages(left,right);
        if (isEven(left)&&isOdd(right)){

        }else {
            throw new Exception("홀수 짝수가 지켜지지 않음");
        }
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

}