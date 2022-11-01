package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int[] p = {pobi.get(0),pobi.get(1)};
        int[] c = {crong.get(0),crong.get(1)};

        String[] pobiLeft = Integer.toString(p[0]).split("");
        String[] pobiRight= Integer.toString(p[1]).split("");
        String[] crongLeft = Integer.toString(c[0]).split("");
        String[] crongRight = Integer.toString(c[1]).split("");

        int[] temp1 = {0,0,1,1};
        int[] temp2 = {0,0,1,1};
        int max = 0;

        //포비-페이지 계산 기능
        for(int i=0;i<pobiLeft.length;i++) {
            //int[] temp = new int[4];
            temp1[0] += Integer.parseInt(pobiLeft[i]); //왼쪽페이지 합
            temp1[1] += Integer.parseInt(pobiRight[i]); //오른쪽페이지 합
            temp1[2] *= Integer.parseInt(pobiLeft[i]); //왼쪽 곱
            temp1[3] *= Integer.parseInt(pobiRight[i]); //오른쪽 곱
        }

        //포비-최댓값 저장 기능
        System.out.println(temp1[0]+","+temp1[1]+","+temp1[2]+","+temp1[3]);
        System.out.println(max);
        for(int i=0;i<4;i++) {
            if (max < temp1[i]) {
                max = temp1[i];
                System.out.println(max);
            }
        }
        int pobiMax = max;

        //크롱-페이지 계산 기능
        for(int i=0;i<crongLeft.length;i++) {

            temp2[0] += Integer.parseInt(crongLeft[i]);
            temp2[1] += Integer.parseInt(crongRight[i]);
            temp2[2] *= Integer.parseInt(crongLeft[i]);
            temp2[3] *= Integer.parseInt(crongRight[i]);
        }

        //크롱-최댓값 저장 기능
        System.out.println(temp2[0]+","+temp2[1]+","+temp2[2]+","+temp2[3]);
        System.out.println(max);

        max = 0;
        for(int i=0;i<4;i++) {
            if (max < temp2[i]) {
                max = temp2[i];
                System.out.println(max);
            }
        }

        //승자 출력 기능


       int answer = nteger.MAX_VALUE;
        return answer;
    }
}