package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int p = pageCal(pobi);
        int c = pageCal(crong);

        int answer = Integer.MAX_VALUE;
        if( p == -1 || c == -1){
            answer = -1;
        }
        else if(p > c){
            answer = 1;
        }else if (p < c){
            answer = 2;
        }else{
            answer = 0;
        }
        return answer;
    }
    public static int pageCal(List<Integer> input){

        if((input.get(0)+1) != input.get(1)) return -1;

        int plus = 0;
        int mul = 1;
        int tmp = 0;

        int max = Integer.MIN_VALUE;

        for(int i =0 ; i < input.size() ;i++){
            plus = 0;
            mul = 1;
            tmp = input.get(i);
            while(tmp%10 != 0){
                plus = plus + (tmp % 10);
                mul = mul * (tmp % 10);
                tmp = tmp / 10;
            }
            if( plus > mul ) tmp = plus;
            else tmp = mul;

            if ( max < tmp ) max = tmp;
        }
        return max;
    }
}