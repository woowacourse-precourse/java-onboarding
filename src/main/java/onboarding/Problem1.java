package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /*
    page가 올바르게 입력되어 있는지 체크 (차이는 무조건 1이어야함)
     */
    private static boolean checkPage(List<Integer> man){
        if(man.get(1).intValue()-man.get(0).intValue()!=1){
            return false;
        }
        return true;
    }

    /*
    뽑은 페이지 더하기 기능
     */
    private static int plusIndex(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }

}