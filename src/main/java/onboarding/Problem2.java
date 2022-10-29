package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        return answer;
    }

    /**
     * @param str : 문자열
     * @return str을 한글자씩 자른 ArrayList<String>
     */
    private static ArrayList<String> splitStringToArrayList(String str){
        String[] strArray = str.split("");
        return  new ArrayList<>(Arrays.asList(strArray));
    }

    /**
     * @param cryptogram : 복호화 하고싶은 문자열(한글자씩 ArrayList<String> 타입)
     * @return 복호화된 문자열
     */
    private static String decryption(ArrayList<String> cryptogram){
        int count = 0;
        for(int i=1; cryptogram.size() > i; i++){
            if(cryptogram.get(i).equals(cryptogram.get(i-1))){
                int start = i-1;
                count++;
                while(cryptogram.size() > i && cryptogram.get(i).equals(cryptogram.get(i-1))){
                    i++;
                }
                for(int j=0;i - start > j; j++){
                    cryptogram.remove(start);
                }
            }
        }
        if(count != 0){
            decryption(cryptogram);
        }
        return String.join("",cryptogram);
    }
}
