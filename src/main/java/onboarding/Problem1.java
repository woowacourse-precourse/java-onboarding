package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobis=0;
        int crongs=0;
        int[] plussum = new int[2];
        int[] multsum = new int[2];
        int[] pobisum = new int[3];
        int[] crongsum = new int[3];
        Arrays.fill(multsum,1);
        if((pobi.get(0)+1)!=pobi.get(1) || (crong.get(0)+1)!=crong.get(1))
        {
            answer=-1;
        }
        else
        {
            for(int i=0; i<2;i++)
            {
                pobis =pobi.get(i);
                while(pobis>0)
                {
                    plussum[i] += pobis % 10;
                    multsum[i] *= pobis % 10;
                    pobis /= 10;
                }
                pobisum[i]= Math.max(plussum[i], multsum[i]);
                crongs=crong.get(i);
                Arrays.fill(plussum,0);
                Arrays.fill(multsum,1);
                while(crongs>0)
                {
                    plussum[i] += crongs % 10;
                    multsum[i] *= crongs % 10;
                    crongs /= 10;
                }
                crongsum[i]= Math.max(plussum[i], multsum[i]);
            }
            pobisum[2] = Math.max(pobisum[0], pobisum[1]);
            crongsum[2]= Math.max(crongsum[0],crongsum[1]);
            if(pobisum[2]>crongsum[2])
            {
                answer=1;
            }
            else if(pobisum[2]==crongsum[2])
            {
                answer=0;
            }
            else
            {
                answer=2;
            }
        }
        return answer;
    }
}