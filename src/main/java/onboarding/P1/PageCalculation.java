package onboarding.P1;

import java.util.List;

public class PageCalculation {

    public static int CalculateResult(List<Integer> name){
        return Math.max(PlusMax(name), MultiMax(name));
    }

    private static int PlusMax(List<Integer> user){
        int themax = Math.max(PlusCalculate(user.get(0)), PlusCalculate(user.get(1)));

        return themax;
    }
    private static int MultiMax(List<Integer> user){
        int themax = Math.max(MultiCalculate(user.get(0)), MultiCalculate(user.get(1)));
        return themax;
    }


    private static int PlusCalculate(int pagenumber){
        int sum =0;
        while(pagenumber != 0){
            sum += pagenumber % 10;
            pagenumber /= 10;

        }
        return sum;
    }

    private static int MultiCalculate(int pagenumber){
        int sum = 1;
        while(pagenumber!=0){
            sum *= pagenumber % 10;
            pagenumber /= 10;
        }
        return sum;
    }


}
