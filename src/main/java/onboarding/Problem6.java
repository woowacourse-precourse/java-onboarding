package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> arr = new HashSet<>();

        for(List<String> s : forms){
            if(s.get(1).length() == 1){
                for(List<String> s2 : forms){
                    if(s2.get(1).equals(s.get(1))){
                        if(!s.get(0).equals(s2.get(0))){
                            arr.add(s2.get(0));
                        }
                    }
                }
            }else {
                for(List<String> s2 : forms){
                    for(int i =0; i < s.get(1).length()-1; i++) {
                        if (s2.get(1).matches("(.*)" + s.get(1).substring(i, i+2) + "(.*)")) {
                            if (!s.get(0).equals(s2.get(0))) {
                                arr.add(s2.get(0));
                            }
                        }
                    }
                }
            }

        }

        return new ArrayList<>(arr);
    }
}
