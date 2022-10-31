package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String email;
    private final String name;


    public Student(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public List<String> getSubNames() {
        List<String> subNames = new ArrayList<>();
        for (int i = 0; i < this.name.length() - 1; i++) {
            subNames.add(this.name.substring(i, i + 2));
        }
        return subNames;
    }
}

