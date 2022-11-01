package onboarding;

import java.io.IOException;

public class Problem2 {
    public static String solution(String cryptogram) {
        int startNum = 0, endNum = 0;

        for (int i = 0; i < cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                startNum = i;

                try {
                    while (cryptogram.charAt(startNum) == cryptogram.charAt(++i)) ;
                }catch (IndexOutOfBoundsException e){

                }
                endNum = i;

                StringBuffer str=new StringBuffer(cryptogram);
                cryptogram=str.delete(startNum,endNum).toString();
                i=-1;
            }
        }
        return cryptogram;
    }
}