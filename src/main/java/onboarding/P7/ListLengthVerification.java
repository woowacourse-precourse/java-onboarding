package onboarding.P7;

import java.util.List;

public class ListLengthVerification {
    public boolean listLengthCheck(String user, List<List<String>> friends, List<String> visitors){
        return userlengthcheck(user)
                && friendslengthcheck(friends)
                && friendstwocheck(friends)
                && visitorslengthcheck(visitors);
    }

    private static boolean userlengthcheck(String user){
        return 1 <= user.length() && user.length() <= 30;
    }

    private static boolean friendslengthcheck(List<List<String>> friends){
        return 1 <= friends.size() && friends.size() <= 10000;
    }
    private static boolean friendstwocheck(List<List<String>> friends){
        for(List<String> a: friends){
            if(a.size() !=2){
                return false;
            }
        }
        return true;
    }

    private static boolean visitorslengthcheck(List<String> visitors){
        return 0 <= visitors.size() || visitors.size() <= 10000;
    }
}
