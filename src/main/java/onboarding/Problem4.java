package onboarding;

public class Problem4 {
    public static String solution(String word) {

        return revertArrayToString(convertArray(changeStringToAsciiArray(word)));

    }

    static int[] changeStringToAsciiArray(String text){
        int[] arr = new int[text.length()];
        for(int i=0; i<text.length(); i++){
            arr[i] = (int) text.toCharArray()[i];
        }
        return arr;
    }

    static int[] convertArray(int[] arr){

        for(int i=0; i<arr.length; i++){
            if(arr[i]==32){
                arr[i]=32;
            }else if(arr[i]>=65 && arr[i]<=90){
                arr[i]=155-arr[i];
            }else if(arr[i]>=97 && arr[i]<=122){
                arr[i]=219-arr[i];
            }
        }
        return arr;
    }
    static String revertArrayToString(int [] arr){
        char[] charr = new char[arr.length];
        for(int i=0 ; i<arr.length; i++){
            charr[i]= (char) arr[i];
        }
        return new String(charr);
    }

}
