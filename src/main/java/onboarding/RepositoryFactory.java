package onboarding;

import onboarding.problem7.Problem7Repository;
import onboarding.problem7.Problem7SnsRepository;

import java.util.HashMap;

public interface RepositoryFactory {

    SnsRepository makeRepository();
}
