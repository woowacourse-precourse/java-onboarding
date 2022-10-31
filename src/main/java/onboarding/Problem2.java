package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = return_uncryptedstring(cryptogram);
        return answer;
    }
    public static int continuous_test_status(StringBuffer cryptogram) {
        for(int i=0; i< cryptogram.length()-1;i++) {
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                return 1;
            }
        }
        return 0;
    }

    public static String return_uncryptedstring(String cryptogram){
        StringBuffer sb = new StringBuffer();
        sb.append(cryptogram);
        int start = 0;
        int end = 0;
        while(continuous_test_status(sb)==1) {


            int i=0;
            char prev = sb.charAt(i);
            HashSet<Integer> deleteSet = new HashSet<Integer>();
            i++;
            while (i<sb.length()){

                if(sb.charAt(i) == prev) {
                    deleteSet.add(i-1);
                    deleteSet.add(i);
                }
                else{
                    prev = sb.charAt(i);
                }
                i++;
            }
//            System.out.println(deleteSet);
            List<Integer> deleteList = new ArrayList<>(List.copyOf(deleteSet));
            Collections.sort(deleteList);
            for (int j=deleteList.size()-1; j>=0; j--) {
                sb.deleteCharAt(deleteList.get(j));
            }

        }
        return sb.toString();
    }


}
