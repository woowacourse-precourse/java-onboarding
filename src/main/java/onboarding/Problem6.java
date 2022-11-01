package onboarding;


import java.util.*;
import onboarding.problem6.DuplicateNicknameDetector;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        DuplicateNicknameDetector nicknameDetector = new DuplicateNicknameDetector();

        for(List<String> form : forms){
            nicknameDetector.registerUserAndUpdateDuplicate(form);
        }

        List<String> duplicateNicknameOwnerEmails = nicknameDetector.getDuplicateNicknameOwnerEmails();
        Collections.sort(duplicateNicknameOwnerEmails);;

        return duplicateNicknameOwnerEmails;
    }
}