package onboarding.prob6.domain;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Encoder {

    private Encoder() {
    }

    public static String encode(String s) {
        return URLEncoder.encode(s, StandardCharsets.UTF_8);
    }
}
