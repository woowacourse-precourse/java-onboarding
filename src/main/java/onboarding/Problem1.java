package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {


        if(exception(pobi)||exception(crong)){
            return -1;
        }




        int resultMax = getResultMax(pobi);
        int resultMax1 = getResultMax(crong);


        return getAnswer(resultMax,resultMax1);


    }


    public static int getResultMax(List<Integer> person) {
        int resultMax=0;
        int total;


        for(int i =0;i<2;i++){

            int num = person.get(i);
            int sum1=0;
            int sum2=1;

            while (num!=0){
                sum1+=num%10;
                sum2*=num%10;
                num /= 10;

            }

            total = Math.max(sum1,sum2);

            if(resultMax<total){
                resultMax=total;
            }


        }
        return resultMax;
    }
    public static int getAnswer(int formerResultMax, int latterResultMax) {

        if(latterResultMax > formerResultMax){
            return 2;
        }
        else if (formerResultMax > latterResultMax) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static boolean exception(List<Integer> person){


        return (person.get(0)%2==0 || person.get(1)%2!=0 || person.get(1)-person.get(0)!=1 || person.get(0)<1 || person.get(1)>400);


    }



}