/*
 * Problem4
 *
 * v1.1
 *
 * 2022.11.01
 *
 * 저작권 주의
 */

package onboarding;

public class Problem4 {
    public static String solution(String word) {
        int[] asciiArray= changeStringToAsciiArray(word);
        int[] capitalReverted= revertCapitalUsingAscii(asciiArray);

        return revertArrayToString(capitalReverted);

    }

    static int[] changeStringToAsciiArray(String text){
        int[] arr = new int[text.length()];
        for(int i=0; i<text.length(); i++){
            arr[i] = text.toCharArray()[i];
        }
        return arr;
    }

    static int[] revertCapitalUsingAscii(int[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i]>=65 && arr[i]<=90){
                arr[i]=155-arr[i];
            }
            if(arr[i]>=97 && arr[i]<=122){
                arr[i]=219-arr[i];
            }
        }
        return arr;
    }
    static String revertArrayToString(int [] arr){
        char[] charArray = new char[arr.length];
        for(int i=0 ; i<arr.length; i++){
            charArray[i]= (char) arr[i];
        }
        return new String(charArray);
    }


}
