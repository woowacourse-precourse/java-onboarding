package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String cryptoArray[];
        int consecNum[] = {0, 0};
        int chkArray = 1;
        cryptoArray = cryptogram.split("");
        while(chkArray == 1){
            consecNum = findConsecNum(cryptogram);
            chkArray = consecNum[1];
            if(chkArray == 0){
                break;
            }else{
                cryptoArray = remove(cryptoArray, consecNum[0]);
                cryptoArray = remove(cryptoArray, consecNum[0]);
                List<String> list = new ArrayList<>(Arrays.asList(cryptoArray));
                cryptogram = String.join("", list);
            }
        }
        return cryptogram;
    }
    private static String[] remove(String[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        List<String> result = new ArrayList<>(Arrays.asList(arr));
        result.remove(index);
        return result.toArray(new String[0]);
    }

    public static int[] findConsecNum(String cryptogram) {
        String cryptoArray[];
        int result[] = {0, 0};
        cryptoArray = cryptogram.split("");
        for(int i = 0; i < cryptogram.length(); i++){
            int chkSame = 0;
            if(i+1 == cryptogram.length()-1){
                if(i== 0){
                    if((cryptoArray[i]).equals(cryptoArray[i+1])){
                        result[0] = i;
                        result[1] = chkSame + 1;
                        break;
                    }
                }
                result[0] = i;
                result[1] = chkSame;
                break;

            }
            if((cryptoArray[i]).equals(cryptoArray[i+1])){
                result[0] = i;
                result[1] = chkSame + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        String cryptogram = "browoanoommnaon";
        System.out.println(solution(cryptogram));
    }
}
