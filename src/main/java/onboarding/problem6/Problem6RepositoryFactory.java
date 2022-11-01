package onboarding.problem6;

import onboarding.RepositoryFactory;
import onboarding.SnsRepository;
import onboarding.UserRepository;

public class Problem6RepositoryFactory implements RepositoryFactory {
    @Override
    public SnsRepository makeRepository() {
        return UserRepository.of();
    }
}
