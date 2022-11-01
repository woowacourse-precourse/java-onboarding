package onboarding.pkgProblem4.service;

public class changeOppositeLetterService {

    /**
     * 주어진 문자열의 각각의 알파벳을 반대 전환하는 메소드
     * @param word - 역순으로 변환해야하는 문자열
     * @return 반대로 변환된 문자열
     */
    public String changeLetter(String word) {
        StringBuffer sb = new StringBuffer();
        char[] splitWord = word.toCharArray();

        for (char c : splitWord) {
            if (!Character.isLetter(c)) { //문자가 아니면 그대로 입력
                sb.append(c);
                continue;
            }
            char convert = Character.isUpperCase(c) ? changeUpperCase(c) : changeLowerCase(c); //대,소문자 반대 변환
            sb.append(convert);
        }
        return sb.toString();
    }

    /**
     * ASCII 코드를 이용하여 알파벳을 반대 전환하는 메소드
     * @param c - 알파벳
     * @return 반대로 변환된 알파벳의 ASCII 코드 값
     */
    private char changeUpperCase(char c){
        return (char)('Z'+'A'-c);
    }
    private char changeLowerCase(char c){
        return (char)('z'+'a'-c);
    }
}

