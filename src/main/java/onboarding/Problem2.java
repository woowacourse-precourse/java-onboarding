package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        Cryptogram input = new Cryptogram(cryptogram);
        Cryptogram result = deduplication(input);

        return result.getCryptogram();
    }

    // 중복을 제거하는 재귀함수
    public static Cryptogram deduplication(Cryptogram cryptogram) {

        String currString = cryptogram.getCryptogram();
        int currLength = currString.length();

        cryptogram.removeDuplication();
        int newLength = cryptogram.getSize();

        // 재귀 호출
        if ((newLength < currLength) && (newLength != 0)) {
            return deduplication(cryptogram);
        }
        return cryptogram;
    }
}


class Cryptogram {

    private String cryptogram;

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

    public void removeDuplication() {
        String temp = this.cryptogram;
        int length = temp.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = temp.charAt(i);
            int next = i+1;
            int count = 0;
            if (i == length-1) {
                sb.append(c);
                break;
            }
            while (temp.charAt(next) == c){
                count ++;
                next++;
                if (next == length) {
                    break;
                }
            }
            if (count == 0) {
                sb.append(c);
            }
            i += count;
        }
        this.cryptogram = sb.toString();
    }

    public int getSize() {
        return this.cryptogram.length();
    }

    public String getCryptogram() {
        return this.cryptogram;
    }
}

