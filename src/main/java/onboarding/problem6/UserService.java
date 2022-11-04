package onboarding.problem6;

import onboarding.Domain;
import onboarding.RepositoryFactory;
import onboarding.SnsRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserService{
    static SnsRepository repository;
    static OverLapChecker overLapChecker=new OverLapChecker();

    public UserService(RepositoryFactory repositoryFactory) {
        repository=repositoryFactory.makeRepository();
    }

    public void save(User user) {
        user.validNickName();
        user.validEmail();
        repository.save(user);
    }

    public List<String> getOverlapList() {
        List<User> all = repository.findAll().stream().map(d->(User)d).collect(Collectors.toList());
        return overLapChecker.findOverLapList(all);
    }
}
