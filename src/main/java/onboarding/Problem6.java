package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {

    private static Set<String> duplicationList = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {

        for (int i = 0; i < forms.size(); i++) {

            String expectedName = forms.get(i).get(1);

            for (int j = 0; j < expectedName.length()-1; j++) {

                String expected = expectedName.substring(j, j+2);

                for(int k = 0; k < forms.size(); k++) {

                    if (k != i) {
                        List<String> user = forms.get(k);
                        String email = user.get(0);
                        String name = user.get(1);

                        if (name.contains(expected)) {
                            duplicationList.add(email);
                        }
                    }
                }
            }
        }

        return duplicationList.stream()
            .sorted()
            .collect(Collectors.toList());
    }
}
