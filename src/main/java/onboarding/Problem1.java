package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static int find_max(int x,int y) {
        int left = 0;
        int right = 0;
        if(x<100){
            left=x/10+x%10;
            right=(x/10)*(x%10);
            System.out.println(left);
            System.out.println(right);
        }else{
            left=x/100+x%100/10+x%100%10;
            right=(x/100)*(x%100/10)*(x%100%10);

        }

        if(y<100){
            left=left>=y/10+y%10?left:y/10+y%10;
            right=right>=(y/10)*(y%10)?right:(y/10)*(y%10);
            System.out.println(left);
            System.out.println(right);
        }else{
            left=left>=y/100+y%100/10+y%100%10?left:y/100+y%100/10+y%100%10;
            right=right>=(y/100)*(y%100/10)*(y%100%10)?right:(y/100)*(y%100/10)*(y%100%10);
        }

        return left>=right?left:right;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_left = pobi.get(0),pobi_right = pobi.get(1),crong_left=crong.get(0),crong_right=crong.get(1);
        if(pobi_left==0||crong_left==0||pobi_right==401 || crong_right==401)return -1;
        if(pobi_right-pobi_left!=1||crong_right-crong_left!=1)return -1;

        int pobi_val =find_max(pobi_left,pobi_right), crong_val=find_max(crong_left,crong_right);

        if(pobi_val>crong_val)answer=1;
        else if (pobi_val<crong_val)answer=2;
        else answer=0;
        return answer;
    }


}