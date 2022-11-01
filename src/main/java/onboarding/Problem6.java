package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> duplicateNicknameEmailSet = new TreeSet<>();

        for(int i=0;i<forms.size()-1;i++){
            for(int j=i+1;j<forms.size();j++){
                List<String> list1 = forms.get(i);
                List<String> list2 = forms.get(j);
                if(isDuplicateNickName(list1.get(1), list2.get(1))) {
                    duplicateNicknameEmailSet.add(list1.get(0));
                    duplicateNicknameEmailSet.add(list2.get(0));
                }
            }
        }

        return new ArrayList<>(duplicateNicknameEmailSet);
    }

    public static boolean isDuplicateNickName(String nick1, String nick2) {
        for(int index=0;index<nick1.length()-1;index++){
            String str = nick1.substring(index,index+2);
            if(nick2.contains(str)){
                return true;
            }
        }
        return false;
    }
}