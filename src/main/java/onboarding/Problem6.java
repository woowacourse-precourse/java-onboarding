package onboarding;

import onboarding.problem6.*;

import java.util.List;

public class Problem6 {
    private static UserService userService;
    private static SnsRepository repository;
    public static List<String> solution(List<List<String>> forms) {
        Problem6RepositoryFactory problem6RepositoryFactory = new Problem6RepositoryFactory();
        userService=new UserService(problem6RepositoryFactory);
        repository=problem6RepositoryFactory.makeRepository();
        repository.removeAll();
        for(List<String> form:forms){
            userService.save(new User(form.get(0),form.get(1)));
        }
        List<String> overlapList=userService.getOverlapList();
        return overlapList;
    }
}
