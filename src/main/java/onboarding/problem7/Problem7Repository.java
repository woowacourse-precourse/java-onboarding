package onboarding.problem7;

import onboarding.Domain;
import onboarding.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Problem7Repository extends UserRepository implements Problem7SnsRepository  {
    private static Problem7SnsRepository repository=new Problem7Repository();

    private Problem7Repository() {
        super(new HashMap<>());
    }

    @Override
    public Optional<User> findByUserName(String name) {
        List<User> nameList = dataBase.values().stream().map(u -> (User) u).filter(u -> u.getUserName().equals(name)).collect(Collectors.toList());
        return nameList.isEmpty()?Optional.empty():Optional.of(nameList.get(0));
    }

    public static Problem7SnsRepository of(){
        return repository;
    }
}
