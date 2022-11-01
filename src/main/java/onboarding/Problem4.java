package onboarding;

import onboarding.problem4.domain.FrogWordTranslateStrategy;
import onboarding.problem4.domain.WordTranslateStrategy;
import onboarding.problem4.service.TranslateService;

public class Problem4 {
    public static String solution(String word) {
        WordTranslateStrategy frogWordTranslateStrategy = new FrogWordTranslateStrategy();
        TranslateService translateService = new TranslateService(frogWordTranslateStrategy);
        return translateService.translate(word);
    }
}
