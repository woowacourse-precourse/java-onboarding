package onboarding.problem4.utils;

import onboarding.problem4.service.AlphabetConvertService;

public enum CharType {
    LOWERCASE{
        @Override
        public char convert(char character) {
           return AlphabetConvertService.convert(character, Constants.LOWERCASESTART, Constants.LOWERCASEEND);
        }
    },

    UPPERCASE{
        @Override
        public char convert(char character) {
            return AlphabetConvertService.convert(character, Constants.UPPERCASESTART, Constants.UPPERCASEEND);

        }
    },

    OTHER{
        @Override
        public char convert(char character) {
            return character;
        }
    };

    public abstract char convert(char character);
}
