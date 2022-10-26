package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pmax=0;
        int cmax=0;
            for( int p : pobi){
                int padd=0;
                int pmul=1;
                int pl=(int)(Math.log10(p)+1);
                for(int j=0;j<pl;j++){
                    padd+=p%10;
                    pmul*=p%10;
                    p/=10;
                }
                if(padd>=pmul){
                    pmax=Math.max(pmax,padd);
                }else{
                    pmax=Math.max(pmax,pmul);
                }
            }
            for( int c : crong){
                int cadd=0;
                int cmul=1;
                int cl=(int)(Math.log10(c)+1);
                for(int j=0;j<cl;j++){
                    cadd+=c%10;
                    cmul*=c%10;
                    c/=10;
                }
                if(cadd>=cmul){
                    cmax=Math.max(cmax,cadd);
                }else{
                    cmax=Math.max(cmax,cmul);
                }
            }
        if(pmax>cmax) {
            answer = 1;
        }else if(pmax<cmax){
            answer=2;
        }else answer=0;

        return answer;
    }
}