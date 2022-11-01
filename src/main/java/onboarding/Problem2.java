/*
 * Problem2
 *
 * v1.1
 *
 * 2022.11.02
 *
 * 저작권 주의
 */


package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String solvedCryptogram = cryptogram;

        while(!checkOverlap(solvedCryptogram)){
            solvedCryptogram= removeOverlap(solvedCryptogram);
        }
        return solvedCryptogram;
    }


    static boolean checkOverlap(String str){
        boolean isOverlaped= true;
        for(int i = 0; i < str.length()-1; i++){
            isOverlaped= isCharContinuosOverlaped(str, isOverlaped, i);
        }
        return isOverlaped;
    }
    static boolean isCharContinuosOverlaped(String str, boolean isOverlaped, int index){
        if (str.charAt(index) == str.charAt(index + 1)) {
            isOverlaped = false;
        }
        return isOverlaped;
    }

    static String removeOverlap(String str){
        for(int i = 0; i < str.length()-1; i++){
            str= ifOverlapedRemove(str,i);
        }

        return str;
    }
    static String ifOverlapedRemove(String str, int index){
        if(str.charAt(index) ==str.charAt(index+1)){
            str= str.substring(0, index)+str.substring(index+2, str.length());
        }
        return str;
    }

}