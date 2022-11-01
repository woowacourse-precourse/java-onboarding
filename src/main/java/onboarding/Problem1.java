package onboarding;

import java.util.List;

class Problem1 {

    static int getMax(List<Integer> arr) {

        int lsum=0;
        int lmul=1;
        int rsum=0;
        int rmul=1;

        int lmax=0;
        int rmax=0;

        int tmp;

        int arrLeft=arr.get(0);
        int arrRight=arr.get(1);

        // left sum
        while (arrLeft>0) {
            lsum+=arrLeft%10;
            arrLeft/=10;
        }

        // left multiple
        arrLeft=arr.get(0);
        while (arrLeft>0) {
            tmp=arrLeft%10;
            if (tmp!=0) {
                lmul*=tmp;
            }
            arrLeft/=10;
        }

        //Left max
        if (lsum >= lmul) {
            lmax=lsum;
        }
        else {
            lmax=lmul;
        }
        // right sum
        while (arrRight>0) {
            rsum+=arrRight%10;
            arrRight/=10;
        }

        // right multiple
        arrRight=arr.get(1);
        while (arrRight>0) {
            tmp=arrRight%10;
            if (tmp!=0) {
                rmul*=tmp;
            }
            arrRight/=10;
        }
        // Right max
        if (rsum >= rmul) {
            rmax=rsum;
        }
        else {
            rmax=rmul;
        }

        // REAL MAX
        int Max=0;

        if (rmax >= lmax) {
            Max=rmax;
        }
        else {
            Max=lmax;
        }
        return Max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (pobi.get(0)+1!=pobi.get(1)){
            answer=-1;
            return answer;
        }
        else if (crong.get(0)+1!=crong.get(1)){
            answer=-1;
            return answer;
        }
        int pobiMax=getMax(pobi);
        int crongMax=getMax(crong);

        if (pobiMax > crongMax) {
            answer=1;
        }
        else if (pobiMax < crongMax){
            answer=2;
        }
        else if (pobiMax == crongMax){
            answer=0;
        }
        else {
            answer=-1;
        }
        return answer;
    }
}