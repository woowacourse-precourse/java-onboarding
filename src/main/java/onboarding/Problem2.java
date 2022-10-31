package onboarding;

import onboarding.problem2.Decoder;

public class Problem2 {
    public static String solution(String cryptogram) {
        Decoder decoder = new Decoder(cryptogram);
        while(true)
        {
            Decoder newDecoder = decoder.removeDuplicatedCharacter();
            if(newDecoder.equals(decoder))
            {
                break;
            }

            decoder = newDecoder;
        }
        return decoder.toString();
    }
}
