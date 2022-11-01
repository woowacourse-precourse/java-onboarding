package onboarding;

public class Problem4 {
    public static String solution(String word) {


        char[] wordToArray = word.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < wordToArray.length; i++)
        {
            // 만약 공백이라면 빌더에 공백 추가
            if(wordToArray[i] == ' ')
            {
                sb.append(' ');
            }
            else
            {
                char convert;

                // 대문자일때 아스키코드 값 계산
                if(Character.isUpperCase(wordToArray[i]))
                {
                    convert =  (char) (155 - (int)wordToArray[i]);
                }
                // 소문자일때 아스키코드 값 계산
                else
                {
                    convert = (char) (219 - (int)wordToArray[i]);
                }

                sb.append(convert);
            }
        }

        String answer = sb.toString();
        return answer;
    }
}
