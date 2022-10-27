package onboarding.problem4.domain;

import onboarding.problem4.domain.strategy.AlphabetConvertStrategy;
import onboarding.problem4.domain.strategy.LowerCaseConvertStrategy;
import onboarding.problem4.domain.strategy.UpperCaseConvertStrategy;

public class AlphabetConvertor {
    public static char convertAlphabet(final char alphabet) {
        if (Character.isUpperCase(alphabet)) {
            return convert(new UpperCaseConvertStrategy(), alphabet);
        }
        
        return convert(new LowerCaseConvertStrategy(), alphabet);
    }
    
    private static char convert(final AlphabetConvertStrategy alphabetConvertStrategy, final char alphabet) {
        return alphabetConvertStrategy.convert(alphabet);
    }
}
