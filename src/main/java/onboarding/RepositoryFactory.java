package onboarding;

public class RepositoryFactory {
    static SnsRepository repository=new UserRepository();
    public static SnsRepository makeRepository() {
        return repository;
    }
}
