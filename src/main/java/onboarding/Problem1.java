package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(((pobi.get(0)+1)!=(pobi.get(1)))||((crong.get(0)+1)!=(crong.get(1)))){
            answer=-1;
            return answer;
        }
        if((pobi.get(0)<1 || pobi.get(1)>400)||(crong.get(0)<1 || crong.get(1)>400)){
            answer=-1;
            return answer;
        }
        if((pobi.get(0)%2==0) || (crong.get(0)%2==0)){
            answer=-1;
            return answer;
        }

        int[] pobi_num=new int[2];
        int pobi_max;
        int sum=0, mul=1;

        for(int i=0;i<2;i++) {
            int num=pobi.get(i);
            int num2=pobi.get(i);

            while (num!= 0) {
                sum += num % 10;
                num /= 10;
            }
            while (num2 != 0) {
                mul *= num2 % 10;
                num2 /= 10;
            }
            if (sum > mul) pobi_num[i] = sum;
            else pobi_num[i] = mul;

            sum=0;
            mul=1;
        }
        if (pobi_num[0] > pobi_num[1]) pobi_max = pobi_num[0];
        else pobi_max = pobi_num[1];

        int[] crong_num=new int[2];
        int crong_max;

        for(int i=0;i<2;i++) {
            int num=crong.get(i);
            int num2=crong.get(i);

            while (num!= 0) {
                sum += num % 10;
                num /= 10;
            }
            while (num2 != 0) {
                mul *= num2 % 10;
                num2 /= 10;
            }
            if (sum > mul) crong_num[i] = sum;
            else crong_num[i] = mul;

            sum=0;
            mul=1;
        }
        if (crong_num[0] > crong_num[1]) crong_max = crong_num[0];
        else crong_max = crong_num[1];

        if(pobi_max>crong_max) answer=1;
        else if(pobi_max==crong_max) answer=0;
        else answer=2;

        return answer;
    }
}