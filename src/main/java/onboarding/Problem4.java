package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] alphabet= new char[26];
        alphabet[0] = 'A';
        alphabet[1] = 'B';

        for(int i = 0; i < alphabet.length; i++){
            alphabet[i] = (char)('A' + i);
        }

        for(int i=0; i<word.length(); i++){
            int j =0;       // j 변수를 for문 밖에서 사용하기 위함
            for(j=0; j<alphabet.length; j++){
                if(Character.isUpperCase(word.charAt(i))){
                    if(word.charAt(i) == Character.toUpperCase(alphabet[j])){
                        answer += Character.toUpperCase(alphabet[25-j]);
                        break;
                    }
                }

                else{
                    if(word.charAt(i) == Character.toLowerCase(alphabet[j])){
                        answer += Character.toLowerCase(alphabet[25-j]);
                        break;
                    }
                }
            }
            // break를 못 만나서, j == alphabet.length 가 된 경우는 공백일 때
            if (j == alphabet.length){
                answer += " ";
            }
        }

        return answer;
    }
}
