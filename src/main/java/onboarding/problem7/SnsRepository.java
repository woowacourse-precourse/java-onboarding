package onboarding.problem7;

import java.util.List;
import java.util.Optional;

public interface SnsRepository {
    Domain save(Domain user);

    void removeAll();

    Optional<Domain> findById(int id);

    Domain update(Domain user);

    List<Domain> findAll();

    int lastIdNumber();
}
