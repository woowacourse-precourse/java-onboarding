package onboarding;

// 길이가 1 이상 1000 이하인 문자열을 받는다.
// 알파벳 외의 문자는 변환하지 않고, 대문자는 대문자로 소문자는 소문자로 변환한다.
// 문자열의 각 문자를 a -> z로, b -> y로, ... , Z -> A로 변환 후 반환

// todo
// 1. 각 문자를 변환하는 과정에서 규칙성 찾아보기
// 1-2. 문자를 숫자로 변환해보기
// 1-3. 숫자를 문자로 변환해보기
// 2. 발견한 규칙((첫문자+끝문자)-해당문자)을 바탕으로 소문자, 대문자, 공백일때의 상황으로 분류해 조건 설정하기
// 2-1. 문자를 숫자로 변환 후 공식에 대입
// 2-2. 대입한 결과를 다시 문자로 변환
// 2-3. 반환한 문자들을 합해서 결과로 반환

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // A = 65
        // Z = 90
        // a = 97
        // z = 122

        // A~Z -> (65+90) - char
        // a~z -> (97+122) - char
        // " " -> " "

        for (int i = 0; i < word.length(); i++) {
            System.out.println(word.charAt(i));

            if(word.charAt(i) == ' '){
                answer += ' ';
            }

            int asciichar = word.charAt(i);

            if(65 <= asciichar && asciichar <= 90){
                answer += (char)(155 - asciichar);
            }else if(97 <= asciichar && asciichar <= 122){
                answer += (char)(219 - asciichar);
            }
        }

        System.out.println(answer);

        return answer;
    }
}
