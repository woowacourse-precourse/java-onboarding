package onboarding.prob6.domain;

import java.util.Collections;
import java.util.List;

public class FormDummy {
    private static final List<List<String>> forms = List.of(Collections.emptyList());

    public static List<List<String>> getForms() {
        return forms;
    }
}
