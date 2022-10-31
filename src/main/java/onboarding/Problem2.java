package onboarding;

import onboarding.problem2.TypeConverter;
import onboarding.problem2.CryptogramDecoder;

import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {

        List<Character> cryptogramCharList = TypeConverter.stringToCharacterList(cryptogram);
        List<Character> decodedCharList = CryptogramDecoder.decode(cryptogramCharList);
        return TypeConverter.characterListToString(decodedCharList);
    }
}
