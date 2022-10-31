package onboarding;

import java.util.List;

class Problem1 {

    static int pobiMax = 0;
    static int crongMax = 0;

    public static int getMax(int number) {
        int arrMax[]={0,0};
        for (int i = 0; i < 2; i++) {
            String tmp = Integer.toString(number + 1);
            String[] array = tmp.split("");

            int plusSum = 0, mulSum = 1;

            for (int j = 0; j < array.length; j++) {
                plusSum += Integer.parseInt(array[j]);
                mulSum *= Integer.parseInt(array[j]);
            }
            if(plusSum>mulSum)
                arrMax[i]=plusSum;
            else
                arrMax[i]=mulSum;
        }
        if(arrMax[0]>arrMax[1])
            return arrMax[0];
        return arrMax[1];
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(Math.abs(pobi.get(0)-pobi.get(1))==1 && Math.abs(crong.get(0)-crong.get(1))==1){
            pobiMax = getMax(pobi.get(0));
            crongMax = getMax(crong.get(0));

            if(pobiMax>crongMax)
                answer=1;
            else if(pobiMax<crongMax)
                answer=2;
            else if(pobiMax==crongMax)
                answer=0;
        }else
            answer=-1;

        //System.out.println("pobimax: "+pobiMax+", crongMax:"+crongMax+", answer: "+answer);

        return answer;
    }
}
