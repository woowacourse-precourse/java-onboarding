package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int tempPobi = 0;
        int tempCrong = 0;

        for(int i = 0; i < 2; i++) {
            String[] idx=Integer.toString(pobi.get(i)).split("");
            int temp=0;
            for (String s : idx) {
                temp+= Integer.parseInt(s);
            }
            if (tempPobi < temp) {
                tempPobi=temp;
            }
            temp=1;
            for (String s : idx) {
                temp*= Integer.parseInt(s);
            }
            if (tempPobi < temp) {
                tempPobi=temp;
            }
        }
        for(int j = 0; j < 2; j++) {
            String[] idx=Integer.toString(crong.get(j)).split("");
            int temp=0;
            for (String s : idx) {
                temp+= Integer.parseInt(s);
            }
            if (tempCrong < temp) {
                tempCrong=temp;
            }
            temp=1;
            for (String s : idx) {
                temp*= Integer.parseInt(s);
            }
            if (tempCrong < temp) {
                tempCrong=temp;
            }

        }
        if ((pobi.get(1) - pobi.get(0)) != 1 || (crong.get(1) - crong.get(0)) != 1) {
            answer=-1;
        } else if (tempPobi > tempCrong) {
            answer = 1;
        } else if (tempCrong < tempPobi) {
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }
}