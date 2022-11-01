package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        List <Integer> list=new ArrayList<>();
        initList(list,number);
        for(int i=0;i< list.size();i++){
            answer+=clapCounter(integerParser(list.get(i).intValue()));
        }

        return answer;
    }

    private static int clapCounter(List<Integer> integerParser) {
        int clapcount=0;
        for(int i=0;i<integerParser.size();i++){
            if(integerParser.get(i).intValue()==3||integerParser.get(i).intValue()==6||integerParser.get(i).intValue()==9)
                clapcount++;
        }
        return clapcount;
    }

    private static List<Integer> integerParser(int intValue) {
        List<Integer> parsedInt=new ArrayList<>();
        while(intValue!=0){
            parsedInt.add(intValue%10);
            intValue/=10;
        }
        return parsedInt;
    }


    private static List<Integer> initList(List<Integer> list,int number) {
        for(int i=0;i<number;i++)
            list.add(i+1);
        return list;
    }
}
