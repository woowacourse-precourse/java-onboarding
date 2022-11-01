package onboarding.problem4.service;

import onboarding.problem4.domain.WordTranslateStrategy;

public class TranslateService {

    private final WordTranslateStrategy wordTranslateStrategy;

    public TranslateService(WordTranslateStrategy wordTranslateStrategy) {
        this.wordTranslateStrategy = wordTranslateStrategy;
    }

    public String translate(String word) {
        return wordTranslateStrategy.translate(word);
    }
}
