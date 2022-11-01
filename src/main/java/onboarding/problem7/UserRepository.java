package onboarding.problem7;

import java.util.HashSet;
import java.util.Set;

public class UserRepository {
    private Set<String> userGroup = new HashSet<>();

    public void addUserIfNotExist(String userId){
        userGroup.add(userId);
    }

    public Set<String> getUserGroup(){
        return new HashSet<>(userGroup);
    }
}
