package onboarding.problem7.repository;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepositoryImpl implements UserRepository {

    private static Map<String, Set<String>> store = new ConcurrentHashMap<>();

    @Override
    public String save(String userName, Set<String> friends) {
        store.put(userName, friends);
        return userName;
    }

    @Override
    public Set<String> findFriends(String userName) {
        return store.getOrDefault(userName, new LinkedHashSet<>());
    }

    @Override
    public boolean existsUser(String userName) {
        return store.containsKey(userName);
    }


}
