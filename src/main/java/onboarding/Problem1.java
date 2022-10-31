package onboarding;

import java.util.List;

class Problem1 {
    // 함수 Sum을 만들어 자릿수의 합을 구현해준다
    public static int Sum(int n){
        int a = 0;
        while(n > 0){
            a += n%10;
            n = n/10;

        }
        return a;
    }


}