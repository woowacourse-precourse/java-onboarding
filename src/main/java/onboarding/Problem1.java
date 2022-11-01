package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) != 1){
            return -1;
        }
        if(pobi.get(0) == 0 || crong.get(0) ==0 || pobi.get(1)==400 || crong.get(1) ==400){
            return -1;
        }
        String pobi1 = String.valueOf(pobi.get(0));
        String pobi2 = String.valueOf(pobi.get(1));
        String crong1 = String.valueOf(crong.get(0));
        String crong2 = String.valueOf(crong.get(1));
        int pobis1=0, pobis2=0, crongs1=0, crongs2=0;
        int pobim1=1,pobim2=1,crongm1=1, crongm2=1;

        for(int i=0;i<pobi1.length();i++){
            pobis1 += Integer.parseInt(String.valueOf(pobi1.charAt(i)));
            pobim1 *= Integer.parseInt(String.valueOf(pobi1.charAt(i)));
        }
        for(int i=0;i<pobi2.length();i++){
            pobis2 += Integer.parseInt(String.valueOf(pobi2.charAt(i)));
            pobim2 *= Integer.parseInt(String.valueOf(pobi2.charAt(i)));
        }
        for(int i=0;i<crong1.length();i++){
            crongs1 += Integer.parseInt(String.valueOf(crong1.charAt(i)));
            crongm1 *= Integer.parseInt(String.valueOf(crong1.charAt(i)));
        }
        for(int i=0;i<crong2.length();i++){
            crongs2 += Integer.parseInt(String.valueOf(crong2.charAt(i)));
            crongm2 *= Integer.parseInt(String.valueOf(crong2.charAt(i)));
        }
        int pmax=0,cmax=0;
        if(pobis1>=pobis2){
            pmax = pobis1;
        }else{
            pmax = pobis2;
        }
        if(pmax<pobim1){
            pmax = pobim1;
        }else if(pmax <= pobim2){
            pmax = pobim2;
        }
        if(crongs1>=crongs2){
            cmax = crongs1;
        }else{
            cmax = crongs2;
        }
        if(cmax<crongm1){
            cmax = crongm1;
        }else if(cmax <= crongm2){
            cmax = crongm2;
        }

        if(pmax > cmax){
            answer = 1;
        }else if(cmax > pmax){
            answer = 2;
        }else{
            answer = 0;
        }


        return answer;
    }
}