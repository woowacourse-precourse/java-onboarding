package onboarding;

import onboarding.problem6.*;

import java.util.List;

public class Problem6 {
    private static SnsService userService= ServiceFactory.makeService();
    private static SnsRepository repository= RepositoryFactory.makeRepository();
    public static List<String> solution(List<List<String>> forms) {
        repository.removeAll();
        for(List<String> form:forms){
            userService.save(new User(form.get(0),form.get(1)));
        }
        List<String> overlapList=userService.getOverlapList();
        return overlapList;
    }
}
