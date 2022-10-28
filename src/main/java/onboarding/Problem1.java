package onboarding;

import java.util.List;

class Problem1 {
    public static int firstnumber;
    public static int middlenumber;
    public static int lastnumber;


    public static boolean isSuccessivePage(List<Integer> pagenumber){
        if (pagenumber.get(1) - pagenumber.get(0)!=1){
            return false;
        }else{
            return true;
        }
    }

    public static boolean isLeftOddNumber(List<Integer> pagenumber){
        if(pagenumber.get(0)%2==1){
            return true;
        }else{
            return false;
        }
    }

    public static void divideNumber(int pagenumber){
        firstnumber=pagenumber/100;
        middlenumber=pagenumber/10;
        lastnumber=pagenumber%10;
    }

    public static int sumNumber(){
        int plusnumber=firstnumber+middlenumber+lastnumber;
        return plusnumber;
    }

    public static int multipleNumber(){
        int multinumber;
        if(firstnumber==0&&middlenumber==0){
            multinumber=lastnumber;
        }else if(firstnumber==0&&middlenumber!=0){
            multinumber=middlenumber*lastnumber;
        }else{
            multinumber=firstnumber*middlenumber*lastnumber;
        }
        return multinumber;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(isSuccessivePage(pobi)==false||isSuccessivePage(crong)==false){
            answer=-1;
            return answer;
        }
        if(isLeftOddNumber(pobi)==false||isLeftOddNumber(crong)==false){
            answer=-1;
            return answer;
        }


        return answer;
    }
}