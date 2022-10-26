package onboarding.problem1;

public class Calculator {
    public int sum(int lp, int rp){
        int lSum = 0, rSum = 0;
        while(lp != 0){
            lSum += lp%10;
            lp /= 10;
        }
        while(rp != 0){
            rSum += rp%10;
            rp /= 10;
        }
        return Math.max(lSum, rSum);
    }

    public int mul(int lp, int rp){
        int lMul = 1, rMul = 1;
        while(lp != 0){
            lMul *= lp%10;
            lp /= 10;
        }
        while(rp != 0){
            rMul += rp%10;
            rp /= 10;
        }
        return Math.max(lMul, rMul);
    }

}
