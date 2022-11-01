package onboarding;

import onboarding.problem6.Selector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Selector selector = new Selector(forms);
        return selector.findEmailsWithDuplicatedName();
    }

}