package onboarding.prob2.domain;

public class Processor {
    public String solve(String password) {
        return process(password);
    }
    final String process(String password) {
        String origin = password;
        Decoder decoder = new Decoder();
        while (true) {
            String code = decoder.decode(origin);
            if (code.equals(origin)) break;
            origin = code;
        }
        return origin;
    }
}
