package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

    }

    private static boolean isDuplicateNicName(String name, String compare) {
        int nameLen = name.length();
        int compareLen = compare.length();
        for(int m = 1; m < nameLen; m++){
            for(int n = 1; n < compareLen; n++){
                if(name.substring(m-1,m+1).equals(compare.substring(n-1,n+1))){
                    return true;
                }
            }
        }
        return false;
    }
}
