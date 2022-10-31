package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for(char c : word.toCharArray()) {
            if(Character.isAlphabetic(c))
                sb.append(reverse_char(c));

            else sb.append(c);
        }

        answer = sb.toString();
        return answer;
    }

    /*
        아스키 코드 상에서 알파벳은 대문자가 65번부터 90번이고, 소문자는
        97번부터 122번에 해당한다. 이 점을 생각하여 주어진 입력 문자에 대해
        해당 문자가 아스키 코드의 알파벳 순서에서 오름차순으로 몇 번째에 있는 지를 계산하고,
        그 계산 결과를 내림차순에서 몇 번째에 해당하는 값인 지를 찾아 반환한다.
    */
    private static char reverse_char(char c){
        int pos = 0;

        if(Character.isLowerCase(c)){
            pos = c - 97;
            return (char)(122 - pos);
        }

        else{
            pos = c - 65;
            return (char)(90 - pos);
        }
    }
}
