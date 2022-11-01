package onboarding;

import java.util.*;
public class Problem2 {
    public static List<String> removeDoubleString(List<String> arr, int size) {
        List<String> result = new ArrayList<>();
        for (int k=0;k<size-1;k++) {
            if(result.size() != 0) { break; }
            if(arr.get(k).equals(arr.get(k+1))) {
                for (int i=0;i<size;i++) {
                    if(i == 0) {
                        if (!(arr.get(i+1).equals(arr.get(i)))) {
                            result.add(arr.get(i));
                        }
                    } else if(i == arr.size()-1) {
                        if (!(arr.get(i).equals(arr.get(i-1)))) {
                            result.add(arr.get(i));
                        }
                    } else {
                        if (!(arr.get(i+1).equals(arr.get(i))) && !(arr.get(i).equals(arr.get(i-1)))) {
                            result.add(arr.get(i));
                        }
                    }
                }
            }
        }
        if (result.size() == 0) { return arr; }
        else { return removeDoubleString(result, result.size()); }
    }
    public static String solution(String cryptogram) {
        List<String> word_arr = Arrays.asList(cryptogram.split(""));
        List<String> answer = removeDoubleString(word_arr, word_arr.size());

        return String.join("",answer);
    }
}