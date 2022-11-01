package onboarding.problem6;

public class RepositoryFactory {
    static SnsRepository repository=new UserRepository();
    public static SnsRepository makeRepository() {
        return repository;
    }
}
