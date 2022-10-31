package onboarding.prob6.domain;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Decoder {

    private Decoder() {
    }

    public static String decode(String s) {
        return URLDecoder.decode(s, StandardCharsets.UTF_8);
    }
}
