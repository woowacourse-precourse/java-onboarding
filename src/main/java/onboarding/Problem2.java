package onboarding;

import java.lang.reflect.Array;
import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        if( cryptogram.length() == 1 ){
            return cryptogram;
        }

        char[] arrChars = cryptogram.toCharArray();
        List<Integer> sameIdxList = null;
        Set SameIdeSet = null;
        char[] resultChars = null;


        do {
            SameIdeSet = new HashSet();

            for (int i = 0 ; i < arrChars.length-1; i++) {

                if(arrChars[i] == arrChars[i + 1]){
                    SameIdeSet.add(i);
                    SameIdeSet.add(i+1);
                }
            }
            // System.out.println(SameIdeSet);


            if(SameIdeSet.size()!=0){
                sameIdxList = new ArrayList<>(SameIdeSet);
            } else {
                return new String(arrChars);
            }


            resultChars = new char[arrChars.length-sameIdxList.size()];

            for(int i =0, listCnt=0, resultCnt=0; i<arrChars.length; i++){
                if(i==(int)sameIdxList.get(listCnt)){
                    listCnt++;
                    if(listCnt==sameIdxList.size()) {listCnt--;}
                } else {
                    resultChars[resultCnt] = arrChars[i];
                    resultCnt++;
                    if(resultCnt==resultChars.length) {break;}
                }
            }

            arrChars = new char[resultChars.length];
            arrChars = resultChars;

            // System.out.println(arrChars);

        } while(SameIdeSet.size() > 0);

        answer = new String(arrChars);
        return answer;
    }

    /*public static void main(String[] args){
        String cryptogram =  "browoanoommnaon";
        System.out.println(solution(cryptogram));
    }*/


}
