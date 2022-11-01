package ExceptionValidation;

//- 입력이 1~1000인지 판단
//- 아니면 "" 문자열 반환

public class P4ExceptionValidation {

    public static boolean p4ExceptionValidation(String word){

        return inputBetween1and1000(word);

    }

    private static boolean inputBetween1and1000(String word) {
        if (word.length() < 1 || word.length() > 1000) {
            return false;
        }
        return true;
    }

}
