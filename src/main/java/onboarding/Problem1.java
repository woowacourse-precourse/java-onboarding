package onboarding;

import java.util.List;
import java.util.Random;
//페이지번호를 더하거나 곱해서 높은걸로 반환하는 기능
//포비가 이기면 1  크롱이 이기면 2 무승부 0 예외 -1리턴
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if((pobi.get(0)+1==pobi.get(1))&&(crong.get(0)+1== crong.get(1))){
        int pobimax=resultMax(pobi);
        int crongmax=resultMax(crong);
        if(pobimax>crongmax){
            answer=1;
        }else if(pobimax<crongmax){
            answer=2;
        }else  if(pobimax==crongmax)
            answer=0;}
        else answer=-1;
        return answer;
    }
    public static int resultMax(List<Integer> list){
        int Plusmax;//더하기 최대값
        int Multimax;//곱하기 최대값
        int result;
        Plusmax=PlusMax(list.get(0), list.get(1));
        Multimax = Multimax(list.get(0), list.get(1));
        result=CheckMax(Plusmax, Multimax);
        return result;
        }

    public static int PlusMax(int odd,int even){ //각 자리수의 합을 구하는 기능
            int sum=0;
            if(even%10==0){//페이지가 39 40처럼 앞자리수가 달라질때를 구분
            while(odd!=0){
                sum+=odd%10;
                odd/=10;
            }} else {
                while(even!=0){
                    sum+=even%10;
                    even/=10;
                }
            }
            return sum;
    }
    public static int Multimax(int odd,int even) {
        int multiodd = 1;
        int multieven = 1;
        int result;
        while (odd != 0) {
            multiodd *= odd % 10;
            odd /= 10;
        }
        while (even != 0) {
            multieven *= even % 10;
            even /= 10;
        }
        result =CheckMax(multieven, multiodd);
        return result;
    }
    public static int CheckMax(int A,int B){
        if(A>B){
            return A;
        }else if(A<B){
            return B;
        }else return A;
    }
    }
