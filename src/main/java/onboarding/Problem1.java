package onboarding;

import java.util.List;

class Problem1 {
    int Sum(int x){
        int ret=0;

        while(x!=0){
            ret+=x%10;
            x/=10;
        }

        return ret;
    }

    int Mul(int x){
        int ret=1;

        while(x!=0){
            ret*=x%10;
            x/=10;
        }

        return ret;
    }

    boolean exception(List<Integer> page){
        int leftPage=page.get(0),rightPage=page.get(1);
        if(leftPage>rightPage || rightPage-leftPage!=1 || leftPage%2!=1 || rightPage%2!=0){
            return true;
        }
        else{
            return false;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 prob=new Problem1();
        int answer = Integer.MAX_VALUE;

        if(prob.exception(pobi) || prob.exception(crong)){
            return -1;
        }

        int pobiLeftSum=prob.Sum(pobi.get(0)),pobiLeftMul=prob.Mul(pobi.get(0));
        int pobiLeftMax=Math.max(pobiLeftSum,pobiLeftMul);

        int pobiRightSum=prob.Sum(pobi.get(1)),pobiRightMul=prob.Mul(pobi.get(1));
        int pobiRightMax=Math.max(pobiRightSum,pobiRightMul);

        int pobiMax=Math.max(pobiLeftMax,pobiRightMax);

        int crongLeftSum=prob.Sum(crong.get(0)),crongLeftMul=prob.Mul(crong.get(0));
        int crongLeftMax=Math.max(crongLeftSum,crongLeftMul);

        int crongRightSum=prob.Sum(crong.get(1)),crongRightMul=prob.Mul(crong.get(1));
        int crongRightMax=Math.max(crongRightSum,crongRightMul);

        int crongMax=Math.max(crongLeftMax,crongRightMax);

        if(pobiMax>crongMax){
            answer=1;
        }
        else if(pobiMax<crongMax){
            answer=2;
        }
        else{
            answer=0;
        }
        
        return answer;
    }
}