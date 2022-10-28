package onboarding;

import java.util.List;

class Problem1 {
    public static int firstnumber;
    public static int middlenumber;
    public static int lastnumber;
    public static int thispagenumber;
    public static int[] personnumber= new int[] {0,0};


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
        int sumnumber=firstnumber+middlenumber+lastnumber;
        return sumnumber;
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

    public static void comparePageNumber(int sum, int multiple){
        if(sum>=multiple){
            thispagenumber=sum;
        }else{
            thispagenumber=multiple;
        }
    }

    public static int whichPageNumber(List<Integer> pagelist){
        int leftpagenumber=pagelist.get(0);
        int rightpagenumber=pagelist.get(1);
        divideNumber(leftpagenumber);
        comparePageNumber(sumNumber(),multipleNumber());
        int leftnumber=thispagenumber;
        divideNumber(rightpagenumber);
        comparePageNumber(sumNumber(),multipleNumber());
        int thispersonnumber=0;
        if(leftnumber>=thispagenumber){
            thispersonnumber=leftnumber;
        }else{
            thispersonnumber=thispagenumber;
        }
        return thispersonnumber;

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
        personnumber[0]=whichPageNumber(pobi);
        personnumber[1]=whichPageNumber(crong);
        if(personnumber[0]>personnumber[1]){
            answer=1;
        }else if(personnumber[0]<personnumber[1]){
            answer=2;
        }else{
            answer=0;
        }



        return answer;
    }
}