package onboarding.problem2;

public class Cryptogram {
    private StringBuilder cryptogram;

    //1.생성자, 문자열 입력받아서 초기화.
    public Cryptogram(String input){
        this.cryptogram = new StringBuilder(input);
    }

    //2.자기자신 1회 돌아서 중복 문자 제거, 만약 한번이라도 제거되면 true반환
    public boolean removeDuplicated(){
        boolean check = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < cryptogram.length(); i++) {
            Character character = cryptogram.charAt(i);
            if (isSameWithBefore(i) || isSameWithNext(i)) {
                check = true;
                continue;
            }
            result.append(character);
        }
        if (check) cryptogram = result;
        return check;
    }

    public String getCryptogram() {
        return cryptogram.toString();
    }

    //3.2번에서 중복인지 체크할 수 있는 조건함수
    private boolean isSameWithNext(int i) {
        return i < cryptogram.length() - 1 && cryptogram.charAt(i) == cryptogram.charAt(i + 1);
    }

    private boolean isSameWithBefore(int i) {
        return i > 0 && cryptogram.charAt(i) == cryptogram.charAt(i - 1);
    }

}
