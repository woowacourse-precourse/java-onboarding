package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int[] pobisum = new int[3];
        int[] crongsum = new int[3];
        if((pobi.get(0)+1)!=pobi.get(1) || (crong.get(0)+1)!=crong.get(1)) //페이지가 이어지지않는 예외 상황
        {
            answer=-1;
        }
        else
        {
            for(int i=0; i<2;i++)
            {
                pobisum[i]=maximum(pobi.get(i));

                crongsum[i]=maximum((crong.get(i)));
            }
            pobisum[2] = compare(pobisum[0], pobisum[1]);

            crongsum[2]= compare(crongsum[0],crongsum[1]);

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
    public static  int compare(int sum1, int sum2)//값을 비교하는 함수
    {
        int sum =0;
        sum = Math.max(sum1,sum2);
        return sum;
    }

    public static int maximum(int number) //페이지의 합 그리고 곱의 크기 대교 메소드
    {
        int sum = 0;
        int multsum = 1;
        int plussum = 0;

        while(number>0)
        {
            plussum += number % 10;
            multsum *= number % 10;
            number /= 10;
        }
        sum= Math.max(plussum, multsum);

        return sum;
    }
}
