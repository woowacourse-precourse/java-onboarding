package onboarding;

import java.util.List;

public interface SnsService {
    void save(User user);

    List<String> getOverlapList();
}
