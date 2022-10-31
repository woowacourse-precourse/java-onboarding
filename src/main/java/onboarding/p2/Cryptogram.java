package onboarding.p2;

public class Cryptogram {

    private final String cryptogram;

    public Cryptogram(String cryptogram) {
        validateLength(cryptogram);
        validateLowerCase(cryptogram);
        this.cryptogram = cryptogram;
    }

    private void validateLength(String cryptogram){
        int length = cryptogram.length();
        if (length == 0) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }
        if (length > 1000) {
            throw new IllegalArgumentException("1000자 이하로 입력해주세요.");
        }
    }

    private void validateLowerCase(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!Character.isLowerCase(cryptogram.charAt(i))) {
                throw new IllegalArgumentException("소문자만 입력할 수 있습니다.");
            }
        }
    }

    public String getCryptogram() {
        return this.cryptogram;
    }

}
