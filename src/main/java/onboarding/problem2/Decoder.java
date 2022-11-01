package onboarding.problem2;

public class Decoder {

    private final static String regex = "([a-z])\\1+";

    public String decode(String code){
        Cryptogram.validate(code);
        return removeRepeatString(code);
    }

    // 연속된 문자열 제거하기 반복하는 메서드
    public String removeRepeatString(String code) {
        String result = code.replaceAll(regex, "");

        if (hasRepeatNum(code)) {
            result = removeRepeatString(result);
        }
        return result;
    }

    public boolean hasRepeatNum(String code) {
        for (int i = 0; i < code.length()-1; i++) {
            if (code.charAt(i) == code.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }

}
