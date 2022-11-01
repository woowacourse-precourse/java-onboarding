package onboarding;

import java.util.List;
class Problem1 {

    public static int each_sum(int a,int b)
    {
        int sum1,sum2;
        sum1=sum2=0;

        while(a>0)
        {
            sum1+=a%10;
            a/=10;
        }

        while(b>0)
        {
            sum2+=b%10;
            b/=10;
        }
        if(sum1>sum2)
            return sum1;
        else
            return sum2;
    }

    public static int each_mul(int a,int b)
    {
        int sum1,sum2;
        sum1=sum2=1;

        while(a>0)
        {
            sum1*=a%10;
            a/=10;
        }

        while(b>0)
        {
            sum2*=b%10;
            b/=10;
        }

        if(sum1>sum2)
            return sum1;
        else
            return sum2;

    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        int pobi_Max=0;
        int crong_Max=0;

        if ((pobi.get(0) + 1 != pobi.get(1)) || (crong.get(0) + 1 != crong.get(1))) {
            answer= -1;
            return answer;
        }
        else if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0 || pobi.get(1) % 2 == 1 || crong.get(1) % 2 == 1) {
            answer= -1;
            return answer;
        }

        int p=each_mul(pobi.get(0),pobi.get(1));
        int q=each_sum(pobi.get(0),pobi.get(1));
        pobi_Max=Math.max(p,q);
        int p2=each_mul(crong.get(0),crong.get(1));
        int q2=each_sum(crong.get(0),crong.get(1));
        crong_Max=Math.max(p2,q2);

        if(pobi_Max>crong_Max)
            answer=1;
        else if(pobi_Max<crong_Max)
            answer=2;
        else
            answer=0;



        return answer;
    }


}