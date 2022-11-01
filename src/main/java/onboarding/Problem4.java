package onboarding;

import java.util.HashMap;
import java.util.Map;

import onboarding.problem4.application.Translator;
import onboarding.problem4.config.TreeFrogDependencyConfigurer;

public class Problem4 {

    private static final TreeFrogDependencyConfigurer treeFrogDependencyConfigurer = new TreeFrogDependencyConfigurer();
    public static String solution(String word) {
        Translator translator = treeFrogDependencyConfigurer.treeFrogTranslator();

        return translator.translate(word);
    }

}
