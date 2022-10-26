package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_L= pobi.get(0);
        int pobi_R= pobi.get(1);
        int crong_L= crong.get(0);
        int corng_R= crong.get(1);
        int pobi_num = 0,crong_num = 0;

        if(pobi_R-1==pobi_L && corng_R-1==crong_L){
            pobi_num=slove(pobi_L,pobi_R);
            crong_num=slove(crong_L,corng_R);

            System.out.println(pobi_num);
            System.out.println(crong_num);

            if(pobi_num>crong_num){
                answer = 1;
            }
            else if (crong_num>pobi_num){
                answer = 2;
            }
            else if (crong_num==pobi_num){
                answer = 0;
            }
        }
        else answer=-1;
        return answer;
    }
    public static int slove(int Lnum, int Rnum) {
        int sum = 0,pro = 0,answer=0;
        int Lsum =0,Rsum=0,Lpro=1,Rpro=1;
        int LLnum =Lnum;
        int RRnum =Rnum;

        while (Lnum>0){
            Lsum += Lnum %10;
            Lnum /= 10;
        }
        while (Rnum>0){
            Rsum += Rnum %10;
            Rnum /= 10;
        }
        if (Lsum>Rsum)sum=Lsum;
        if (Rsum>Lsum)sum=Rsum;


        while (LLnum>0){
            Lpro *= LLnum %10;
            LLnum /= 10;
        }
        while (RRnum>0){
            Rpro *= RRnum %10;
            RRnum /= 10;
        }
        if (Lpro>Rpro)sum=Lpro;
        if (Rpro>Lpro)sum=Rpro;

        if (sum>pro)answer=sum;
        if (pro>sum)answer=pro;

        return answer;
    }
}