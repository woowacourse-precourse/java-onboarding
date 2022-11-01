package onboarding;

import org.assertj.core.internal.Iterables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        char prev;
        String str;
        char voc, voc1;
        int next=0;

        int k;

        do{
            k=0;
            str="";
            if(cryptogram.length()<2){
                break;
            }
            prev = cryptogram.charAt(0);

            for(int i = 1; i < cryptogram.length(); i++) {
                voc = cryptogram.charAt(i);
                if(prev == voc){
                    prev = cryptogram.charAt(i);
                    k++;
                    if (i+1 <cryptogram.length()){
                        voc1 = cryptogram.charAt(i+1);
                    }else{
                        voc1 = prev;
                    }
                    if(prev != voc1){
                        prev = cryptogram.charAt(i+1);

                        if(i+2==cryptogram.length()){
                            str = str +prev;
                        }
                        i++;
                    }
                }else{
                    str = str + prev;
                    prev = cryptogram.charAt(i);
                    if (i+1 == cryptogram.length()){
                        str = str + prev;
                    }
                }
            }
            cryptogram = str;

        }while( k != 0 );
        answer = cryptogram;
        return answer;
    }
}
