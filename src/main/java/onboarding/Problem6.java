package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> mailSet = new HashSet<>();

        for(List<String> val : forms) {

            String email = val.get(0);
            String name = val.get(1);

            for (int i = 0; i < name.length() - 1; i++) {
                for (int j = i + 2; j <= i+2; j++) {
                    String part = name.substring(i, j);  // 2 글자로 검사

                    for(List<String> userList : forms){
                        if(val.equals(userList)) continue;
                        if(userList.get(1).contains(part)){ // 중복되는게 있다면
                            mailSet.add(userList.get(0));
                            mailSet.add(email);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(mailSet);
    }


}
