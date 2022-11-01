package onboarding.problem7;

import onboarding.RepositoryFactory;
import onboarding.SnsRepository;

public class Problem7RepositoryFactory implements RepositoryFactory {
    @Override
    public SnsRepository makeRepository() {
        return Problem7Repository.of();
    }
}
