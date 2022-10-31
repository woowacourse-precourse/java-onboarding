package onboarding;

import java.util.List;
import java.util.Optional;

public interface SnsRepository {
    User save(User user);

    Optional<User> findById(int id);

    void removeAll();

    User update(User user);

    List<User> findAll();
}
