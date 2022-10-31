package onboarding.problem6;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class DuplicateNicknameDetector {
    private Set<String> duplicateNicknameOwnerEmailGroup = new HashSet<>();
    private Map<String,String> slicedNicknameStorage = new HashMap<>();

    public void registerUserAndUpdateDuplicate(List<String> userInfo){
        String userEmail = userInfo.get(0);
        String userNickname = userInfo.get(1);
        
        for(int i = 0 ; i < userNickname.length() - 1; i++){
            String slicedNickname = userNickname.substring(i, i + 2);

            if(slicedNicknameStorage.containsKey(slicedNickname)){
                duplicateNicknameOwnerEmailGroup.add(slicedNicknameStorage.get(slicedNickname));
                duplicateNicknameOwnerEmailGroup.add(userEmail);
            }
            slicedNicknameStorage.put(slicedNickname,userEmail);
        }
    }

    public List<String> getDuplicateNicknameOwnerEmails(){
        return new ArrayList<>(duplicateNicknameOwnerEmailGroup);
    }
}
