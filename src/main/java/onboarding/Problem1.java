package onboarding;

import java.util.List;

class Problem1 {
    public static int calc(int input)
    {
        int ans;
        if(input>99)
        {
            ans=Math.max((input/100 + ((input%100)/10 + input%10)),((input/100) * ((input%100)/10) * (input%10)));
        }
        else
        {
            ans=Math.max(input/10+input%10,((input%100)/10)*(input%10));
        }
        return ans;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong)
    {
        if((pobi.get(0)+1!=pobi.get(1))||crong.get(0)+1!=crong.get(1))
        {
            return -1;
        }
        int pobi_left=pobi.get(0);
        int pobi_right=pobi.get(1);
        int crong_left=crong.get(0);
        int crong_right=crong.get(1);
        int p_l= calc(pobi_left);
        int p_r= calc(pobi_right);
        int c_l= calc(crong_left);
        int c_r= calc(crong_right);
        int p_max=Math.max(p_l,p_r);
        int c_max=Math.max(c_l,c_r);
        int checker=p_max-c_max;
        if(checker<0){return 2;}
        if (checker == 0){return 0;}
        if(checker>0){return 1;}
        return -1;
    }
}