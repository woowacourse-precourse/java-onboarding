package onboarding.problem4.service;

import onboarding.problem4.validation.BlueFrogValidator;

public class BlueFrogService {
    public static String reverseMotherSaying(String sentence) {
        BlueFrogValidator.validate(sentence);
        return reverseSentence(sentence);
    }

    private static String reverseSentence(String word) {
        StringBuilder resultBuilder = new StringBuilder();
        char[] spells = word.toCharArray();
        for (char spell : spells) {
            resultBuilder.append(reverseSpell(spell));
        }
        return resultBuilder.toString();
    }

    private static char reverseSpell(char spell) {
        if (Character.isLowerCase(spell)) {
            return reverseLowerCase(spell);
        } else if (Character.isUpperCase(spell)) {
            return reverseUpperCase(spell);
        }
        return spell;
    }

    private static char reverseUpperCase(char asciiCode) {
        return (char)('Z' - (asciiCode - 'A'));
    }

    private static char reverseLowerCase(char asciiCode) {
        return (char)('z' - (asciiCode - 'a'));
    }
}
