package onboarding.P7;

import java.util.ArrayList;
import java.util.List;

public class IdVerification {
    public boolean friendsSmallIdCheck(List<List<String>> friends, List<String> visitors) {
        List<String> frList = new ArrayList<>();
        friends.forEach(frList::addAll);

        return SmallId(frList) && SmallId(visitors);
    }

    private static boolean SmallId(List<String> id){
        for(String s : id){
            char[] ch = s.toCharArray();

            for(char c : ch){
                if(c >= 'a' && c<= 'z'){
                    return true;
                }
            }
        }
        return false;
    }
}