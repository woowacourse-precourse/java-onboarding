package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> sendEmailList = new HashSet<>();
        int size = forms.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                String myNicName = forms.get(i).get(1);
                String compareNicName = forms.get(j).get(1);

                if(isDuplicateNicName(myNicName, compareNicName)) {
                    sendEmailList.add(forms.get(i).get(0));
                    sendEmailList.add(forms.get(j).get(0));
                    break;
                }
            }
        }

        return sendEmailList.stream()
                .sorted()
                .collect(Collectors.toList());
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
