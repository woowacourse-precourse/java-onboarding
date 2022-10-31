package onboarding.problem6;

import java.util.*;

public class UserRepository implements SnsRepository {
    static Map<Integer,User> dataBase=new HashMap<>();

    @Override
    public User save(User user) {
        user.setIndex(dataBase.size());
        dataBase.put(user.getIndex(),user);
        return user;
    }

    @Override
    public Optional<User> findById(int id) {
        try {
            return Optional.of(dataBase.get(id));
        }catch (NullPointerException e){
            return Optional.empty();
        }
    }

    @Override
    public User update(User user) {
        User dataUser = dataBase.get(user.getIndex());
        dataUser.setNickName(user.getNickName());
        return dataUser;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(dataBase.values());
    }

    @Override
    public void removeAll() {
        dataBase.clear();
    }
}
