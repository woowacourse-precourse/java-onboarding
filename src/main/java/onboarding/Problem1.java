package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int diff;
        int num;
        int sum, mul;
        int p1, c1;
        int[] score = new int[4];

        diff = (pobi.get(1)+crong.get(1))-(pobi.get(0)+crong.get(0));

        if(pobi.contains(1)||pobi.contains(400)||pobi.contains(2)||pobi.contains(399)){
            answer = -1;
        } else if (crong.contains(1)||crong.contains(400)||crong.contains(2)||crong.contains(399)) {
            answer = -1;
        } else if (diff !=2) {
            answer = -1;
        }else{


            for(int i=0; i<2; i++){
                mul =1;
                sum =0;
                num = pobi.get(i);
                while(num !=0){
                    int a = num%10;
                    num = num/10;
                    sum += a;
                    mul *= a;
                }
                p1 = Math.max(sum,mul);
                score[i]=p1;
            }
            p1 = Math.max(score[0], score[1]);

            for(int i=0; i<2; i++){
                mul =1;
                sum =0;
                num = crong.get(i);
                while(num !=0){
                    int a = num%10;
                    num = num/10;
                    sum += a;
                    mul *= a;
                }
                c1 = Math.max(sum,mul);
                score[i+2]=c1;
            }

            c1 = Math.max(score[2], score[3]);

            if (p1 > c1){answer=1;} else if (p1==c1) {
                answer =0;
            } else if (p1 < c1) {
                answer = 2;
            }else {
                answer = -1;
            }
        }



        return answer;

    }
}