package onboarding.problem7;

public class RepositoryFactory {
    static SnsRepository repository=new UserRepository();
    static Problem7SnsRepository problem7SnsRepository=new Problem7Repository();
    public static SnsRepository makeSnsRepository() {
        return repository;
    }
    public static Problem7SnsRepository makeProblem7SnsRepository(){return problem7SnsRepository;}
}
