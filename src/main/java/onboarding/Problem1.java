package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        //예외 먼저 처리
        if(pobi.get(1)-pobi.get(0)!=1||crong.get(1)-crong.get(0)!=1
                ||pobi.get(0)==1||pobi.get(1)==400||crong.get(0)==1||crong.get(1)==400
                ||pobi.get(0)%2==0||pobi.get(1)%2!=0||crong.get(0)%2==0||crong.get(1)%2!=0) answer=-1;
        else{
            String [] pobi_0 = String.valueOf(pobi.get(0)).split("");
            String [] pobi_1 = String.valueOf(pobi.get(1)).split("");
            String [] crong_0 = String.valueOf(crong.get(0)).split("");
            String [] crong_1 = String.valueOf(crong.get(1)).split("");
            int tmp_pobi_0; int tmp_pobi_1; int tmp_crong_0; int tmp_crong_1;

            //pobi계산
            int sum_0=0; int by_0=1; int sum_1=0; int by_1=1;

            for(int i=0;i<pobi_0.length;i++){
                sum_0+=Integer.parseInt(pobi_0[i]);
                by_0*=Integer.parseInt(pobi_0[i]);
            }
            tmp_pobi_0 = Math.max(sum_0, by_0);

            int pobi_max = tmp_pobi_0;

            for(int i=0;i<pobi_1.length;i++){
                sum_1+=Integer.parseInt(pobi_1[i]);
                by_1*=Integer.parseInt(pobi_1[i]);
            }
            tmp_pobi_1 = Math.max(sum_1, by_1);

            if(tmp_pobi_1>pobi_max) pobi_max=tmp_pobi_1;

            //crong 계산
            sum_0=0; by_0=1; sum_1=0; by_1=1;

            for(int i=0;i<crong_0.length;i++){
                sum_0+=Integer.parseInt(crong_0[i]);
                by_0*=Integer.parseInt(crong_0[i]);
            }
            tmp_crong_0 = Math.max(sum_0, by_0);

            int crong_max = tmp_crong_0;

            for(int i=0;i<crong_1.length;i++){
                sum_1+=Integer.parseInt(crong_1[i]);
                by_1*=Integer.parseInt(crong_1[i]);
            }
            tmp_crong_1 = Math.max(sum_1, by_1);

            if(tmp_crong_1>crong_max) crong_max=tmp_crong_1;

            //결과 연산
            if(pobi_max>crong_max) answer=1;
            else if(pobi_max==crong_max) answer=0;
            else answer=2;

        }
        return answer;
    }
}