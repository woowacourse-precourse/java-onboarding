package onboarding.problem7.repository;

import java.util.Set;

public interface UserRepository {

    String save(String userName, Set<String> friends);
    Set<String> findFriends(String userName);

    boolean existsUser(String userName);
}
