package onboarding;

import java.util.List;

class Problem1 {
    public static int exec(List<Integer> list){
        int n1 = list.get(0), n2 = list.get(1);
        if(n1<n2 && n2-n1==1 && n1!=1 && n2!=400){
            return 0;
        }
        else{
            return -1;
        }
    }
    public static int findmax(List<Integer> list){
        int sum, mul, lmax = 0, rmax = 0;
        int n;
        for(int i=0;i<=1;i++){
            n = list.get(i);
            sum = 0;
            mul = 1;
            while(n>0){
                sum+=(n%10);
                mul*=(n%10);
                n/=10;
            }
            if(i==0) {
                if (sum > mul) {
                    lmax = sum;
                } else {
                    lmax = mul;
                }
            }
            else{
                if (sum > mul) {
                    rmax = sum;
                } else {
                    rmax = mul;
                }
            }
        }

        if(lmax>rmax){
            return lmax;
        } else{
            return rmax;
        }
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int p, c, execp, execc;

        execp = exec(pobi);
        execc = exec(crong);
        if(execp==-1 || execc==-1){
            answer=-1;
        }
        else {
            p = findmax(pobi);
            c = findmax(crong);

            if (p > c) {
                answer = 1;
            } else if (p < c) {
                answer = 2;
            } else {
                answer = 0;
            }
        }

        return answer;
    }
}