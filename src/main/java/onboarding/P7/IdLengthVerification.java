package onboarding.P7;

import java.util.ArrayList;
import java.util.List;

public class IdLengthVerification {
    public boolean idLengthCheck(List<List<String>> friends, List<String> visitors){

        List<String> frList = new ArrayList<>();
        friends.forEach(frList::addAll);

        return lengthCheck(frList)
                && lengthCheck(visitors);
    }

    private static boolean lengthCheck(List<String> visitors){
        for(String s : visitors){
            if(1 > s.length() || s.length() > 30){
                return false;
            }
        }
        return true;
    }
}
