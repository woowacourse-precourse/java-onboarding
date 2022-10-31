/*
 * Problem2
 *
 * v1.1
 *
 * 2022.11.01
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

    // 중복확인하는 함수
    static boolean checkOverlap(String str){
        int count =0;
        for(int i = 0; i < str.length()-1; i++){
            if (str.charAt(i) == str.charAt(i + 1)) {
                count =+1;
                break;
            }
        }
        return count==0;
    }

    // 중복 제거하는 함수
    static String removeOverlap(String str){
        char[] charArr = str.toCharArray();
        for(int i = 0; i < charArr.length-1; i++){
            if(charArr[i]==charArr[i+1]){
                charArr[i]='@';//null
                charArr[i+1]='@';
            }
        }

        return new String(charArr).replaceAll("@", "");
    }

}