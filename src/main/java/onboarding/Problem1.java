package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiNum =calculateMax(pobi);
        int crongNum =calculateMax(crong);
        if(!checkPage(pobi)||!checkPage(crong)) return -1;
        else if(pobiNum > crongNum) return 1;
        else if(pobiNum == crongNum) return 0;
        else return 2;
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
    각 사람이 뽑은 페이지들을 통해 큰 수 구하는 메서드
     */
    private static int calculateMax(List<Integer> man){
        int left = man.get(0).intValue();   //Integer unboxing
        int right = man.get(1).intValue();  //Integer unboxing
        int plus=Math.max(plusIndex(left),plusIndex(right));
        int multi=Math.max(multiIndex(left),multiIndex(right));
        int maxNum=Math.max(plus,multi);
        return maxNum;
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

    /*
    뽑은 페이지 곱하기 기능
     */
    private static int multiIndex(int num){
        int sum=1;
        while(num>0){
            sum*=num%10;
            num/=10;
        }
        return sum;
    }
}