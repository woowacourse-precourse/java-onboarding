package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pMax,cMax;

        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1){answer = -1;}
        else{
            pMax = Compare(Max(pobi.get(0)),Max(pobi.get(1)));
            cMax = Compare(Max(crong.get(0)),Max(crong.get(1)));

            //System.out.println(pMax);
            //System.out.println(cMax);
            if(pMax == cMax) answer = 0;
            else if (pMax > cMax) answer = 1;
            else answer = 2;
        }
        return answer;
    }
    public static Integer Max(Integer a){
        //String temp;
        //temp = Integer.toString(a);
        int tempMax,temp;
        int tempAdd = 0;
        int tempMul =1;

        /*for (int i=0; i<temp.length(); i++){
            tempAdd += temp.codePointAt(i);
            tempMul *= temp.codePointAt(i);
        }*/
        while(a != 0){
            temp = a % 10;
            tempAdd += temp;
            tempMul *= temp;
            a /= 10;
        }

        if(tempAdd>=tempMul) tempMax = tempAdd;
        else tempMax = tempMul;

        return tempMax;
    }
    public static Integer Compare(Integer a, Integer b){
        int tempMax;
        if(a > b) tempMax = a;
        else tempMax = b;

        return tempMax;
    }
}