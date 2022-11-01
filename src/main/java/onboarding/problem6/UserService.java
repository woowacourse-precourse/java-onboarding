package onboarding.problem6;

import java.util.List;

public class UserService implements SnsService {
    static SnsRepository repository=RepositoryFactory.makeRepository();
    static OverLapChecker overLapChecker=new OverLapChecker();

    @Override
    public void save(User user) {
        user.validNickName();
        user.validEmail();
        repository.save(user);
    }

    @Override
    public List<String> getOverlapList() {
        List<User> all = repository.findAll();
        return overLapChecker.findOverLapList(all);
    }
}
