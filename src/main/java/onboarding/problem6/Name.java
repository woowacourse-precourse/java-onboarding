package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class Name {
    public static List<String> nameToLexims(String name) {
        List<String> resultRepo = new ArrayList<>();
        for (int j = 0; j < name.length()-1; j++) {
            resultRepo.add(name.substring(j, j + 2));
        }
        return resultRepo;
    }
}
