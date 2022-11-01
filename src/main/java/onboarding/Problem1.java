package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(!(pobi.get(0)%2 == 1 && pobi.get(0) - pobi.get(1) == -1 && crong.get(0) %2 == 1 && crong.get(0) - crong.get(1) == -1))
            return -1;

        int pobiMax;
        int crongMax;

        pobiMax = calc(pobi.get(0),pobi.get(1));
        crongMax = calc(crong.get(0),crong.get(1));

        if(pobiMax > crongMax)
            answer = 1;
        else if(pobiMax < crongMax)
            answer = 2;
        else if(pobiMax == crongMax)
            answer = 0;
        else
            answer = -1;

        return answer;
    }

    static int calc(int first,int second){
        String sFirst = Integer.toString(first);
        String sSecond = Integer.toString(second);

        int mulRes = 1;
        int sumRes = 0;

        int fFinRes = 0;
        int sFinRes = 0;

        for(int i=0;i<sFirst.length();i++) {
            char word = sFirst.charAt(i);

            mulRes *= Integer.parseInt(Character.toString(word));
            sumRes += Integer.parseInt(Character.toString(word));
        }
        fFinRes = Math.max(mulRes,sumRes);

        mulRes = 1;
        sumRes = 0;

        for(int i=0;i<sSecond.length();i++) {
            char word = sSecond.charAt(i);

            mulRes *= Integer.parseInt(Character.toString(word));
            sumRes += Integer.parseInt(Character.toString(word));
        }
        sFinRes = Math.max(mulRes,sumRes);

        return Math.max(fFinRes,sFinRes);
    }
}