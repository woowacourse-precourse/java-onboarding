package onboarding.problem7;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Problem7Repository extends UserRepository implements Problem7SnsRepository  {
    @Override
    public Optional<User> findByUserName(String name) {
        List<User> nameList = dataBase.values().stream().map(u -> (User) u).filter(u -> u.getUserName().equals(name)).collect(Collectors.toList());
        return nameList.isEmpty()?Optional.empty():Optional.of(nameList.get(0));
    }
}
