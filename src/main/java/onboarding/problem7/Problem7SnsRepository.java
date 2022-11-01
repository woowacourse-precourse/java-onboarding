package onboarding.problem7;

import java.util.Optional;

public interface Problem7SnsRepository extends SnsRepository{
    Optional<User> findByUserName(String name);
}
