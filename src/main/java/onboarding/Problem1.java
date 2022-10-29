package onboarding;

import java.util.List;
import java.util.Random;
//페이지번호를 더하거나 곱해서 높은걸로 반환하는 기능
//포비가 이기면 1  크롱이 이기면 2 무승부 0 예외 -1리턴
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static int resultMax(List<Integer> list){
        int Plusmax;//더하기 최대값
        int Multimax;//곱하기 최대값
        Plusmax=PlusMax(list.get(0), list.get(1));
        
        }
    }
    public static int PlusMax(int odd,int max){ //각 자리수의 합을 구하는 기능
            int sum=0;
            if(max%10==0){//페이지가 39 40처럼 앞자리수가 달라질때를 구분
            while(odd!=0){
                sum+=odd&10;
                odd/=10;
            }} else {
                while(max!=0){
                    sum+=max&10;
                    max/=10;
                }
            }
            return sum;
    }
}