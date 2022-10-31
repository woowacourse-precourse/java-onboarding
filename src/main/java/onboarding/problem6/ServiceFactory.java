package onboarding.problem6;

public class ServiceFactory {
    static SnsService service=new UserService();
    public static SnsService makeService() {
        return service;
    }
}
