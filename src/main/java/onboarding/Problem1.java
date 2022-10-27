package onboarding;

import java.util.List;

class Problem1 {
    private static int add(int n){
        int res = 0;
        while(n > 0){
            res += n %10;
            n /= 10;
        }
        return res;
    }
    private static int mul(int n){
        int res = 1;
        while(n>0){
            res *= n %10;
            n /= 10;
        }
        return res;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        /**
         * 페이지 차이가 -1 인지 확인 (예외 체크)
         * 왼쪽 홀수, 오른쪽 짝수
         * 각 자리수를 더하거나 or 곱한다
         * --> max(합,곱)
         */
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1){
            return -1;
        }
        int pobiRes=0;
        int crongRes = 0;
        for(int i = 0; i < 2; i++){
            // pobi의 최고값 고르기
            int a1 = add(pobi.get(i));
            int mul1 = mul(pobi.get(i));
            int n = Math.max(a1,mul1);
            pobiRes = Math.max(n,pobiRes);

            // crong의 최고값 고르기
            int a2 = add(crong.get(i));
            int mul2 = mul(crong.get(i));
            n = Math.max(a2,mul2);
            crongRes = Math.max(n,crongRes);
        }

        if(pobiRes == crongRes){
            answer = 0;
        }
        else{
            answer = pobiRes > crongRes ? 1: 2;
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}