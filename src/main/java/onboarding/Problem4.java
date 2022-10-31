package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = findalp(word);
        return answer;
    }

    //    1.hashmap으로 key,value 저장하는 메서드(아스키코드 활용)
    public static Character dict(Character alp) {
        HashMap<Character, Character> save = new HashMap<>();
        save.put('A', 'Z');
        save.put('B', 'Y');
        save.put('C', 'X');
        save.put('D', 'W');
        save.put('E', 'V');
        save.put('F', 'U');
        save.put('G', 'T');
        save.put('H', 'S');
        save.put('I', 'R');
        save.put('J', 'Q');
        save.put('K', 'P');
        save.put('L', 'O');
        save.put('M', 'N');
        save.put('N', 'M');
        save.put('O', 'L');
        save.put('P', 'K');
        save.put('Q', 'J');
        save.put('R', 'I');
        save.put('S', 'H');
        save.put('T', 'G');
        save.put('U', 'F');
        save.put('V', 'E');
        save.put('W', 'D');
        save.put('X', 'C');
        save.put('Y', 'B');
        save.put('Z', 'A');

        return save.get(alp);
    }

    //    2. 알파벳이 아니면 그대로 가고 알파벳이면 1번 메서드로 변환후 대소문자 맞추기
    public static String findalp(String word) {
        /*문자 하나하나를 쪼개서(띄어쓰기도 포함) 대문자이면 dict에 넣어서 바꾸고 소문자로 변환후 result에 추가*/
        String[] wordIns = word.split("");
        String result = "";
        for (String a : wordIns) {
            if (Character.isUpperCase(a.charAt(0))) {
                String ins = dict(a.charAt(0)).toString();
                result += ins;
                /* 소문자이면 대문자로 바꿔서 dict변환 거친후 result에 추가*/
            } else if (Character.isLowerCase(a.charAt(0))) {
                String dictUpper = dict(a.toUpperCase().charAt(0)).toString();
                String strLower = dictUpper.toLowerCase();
                result += strLower;
                /* 알파벳이 아니면 바로 result에 추가*/
            } else {
                result += a;
            }
        }
        return result;
    }
}
