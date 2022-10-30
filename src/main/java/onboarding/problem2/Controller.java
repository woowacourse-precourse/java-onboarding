package onboarding.problem2;

public class Controller {
    public static String getSolution(String cryptogram) {
        if (Validation.check(cryptogram)) {
            while (Compress.needToCompress(cryptogram)) {
                cryptogram = Compress.compress(cryptogram);
            }
            return cryptogram;
        }
        return Constant.EXCEPTION;
    }
}
