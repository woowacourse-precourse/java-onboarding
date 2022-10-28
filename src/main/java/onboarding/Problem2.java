package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        try{
            while(true){
                List<Integer> duplicatedRange=findFirstDuplicatedRange(cryptogram);
                StringBuilder sb = new StringBuilder();
                cryptogram = removeByRange(cryptogram, duplicatedRange);
            }
        }catch(Exception e){
            return cryptogram;
        }
    }

    private static List<Integer> findFirstDuplicatedRange(String cryptogram)
            throws Exception{
        int si=-1;
        int previous = -1;
        for(int i=0;i<cryptogram.length();i++){
            char c=cryptogram.charAt(i);
            if(previous==-1){
                previous=c;
                si=i;
            }else if(previous==c) {
                // do nothing. go to next iteration.
            }else{
                if(si==i-1){
                    previous=c;
                    si=i;
                }else{
                    return new ArrayList<Integer>(Arrays.asList(si,i-1));
                }
            }
        }
        if(si==cryptogram.length()-1){
            // cannot find duplicate range
            throw new Exception("Cannot find duplicate range.");
        }else{
            return new ArrayList<>(Arrays.asList(si,cryptogram.length()-1));
        }
    }

    private static String removeByRange(String str,List<Integer>range){
        StringBuilder sb=new StringBuilder();
        sb.append(str,0,range.get(0));
        sb.append(str,range.get(1)+1,str.length());
        return sb.toString();
    }
}
