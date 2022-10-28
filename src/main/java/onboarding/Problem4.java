package onboarding;

import java.util.ArrayList;

public class Problem4 {

    public static String solution(String word) {
        String answer = word;
        answer = join(answer);

        return answer;
    }

    public static ArrayList<Integer> cToitran(String w) {
        /**
         * 캐릭터 -> 아스키 코드 변환
         */
        ArrayList<Integer> cToiLst = new ArrayList<>();
        ArrayList<Character> chLst = new ArrayList<>();

        for(int i=0; i< characterArr(w).size(); i++) {
            chLst.add(characterArr(w).get(i));
        }


        for(int i=0; i<chLst.size(); i++) {
            Character c = chLst.get(i);
            int num = (int)c;

            if(num>=65 && num<=90) {
                int tr = 25 - (num - 65);
                int numLast = 65 + tr;
                cToiLst.add(numLast);
            } else if (num == 32) {
                cToiLst.add(num);

            } else {
                int tr = 25 - (num - 97);
                int numLast = 97 + tr;
                cToiLst.add(numLast);
            }

            /**
             * switch문 실패
             */

//            switch (num) {
//                case 1:
//                    if (num>=65 && num<=90) {
//                        int tr = 25 + (num - 65);
//                        int numLast = 65 + tr;
//                        cToiLst.add(numLast);
//                        System.out.println("trNumLast"+cToiLst.add(numLast));
//                    }
//                    break;
//                case 2:
//                    if (num>=97 && num<=122) {
//                        int tr = 25 + (num - 97);
//                        int numLast = 97 + tr;
//                        cToiLst.add(numLast);
//                    }
//                    break;
//            }
        }

        return cToiLst;
    }

    public static ArrayList<Character> iToCtran(String w) {
        /**
         * 아스키코드 -> 캐릭터 변환
         */
        ArrayList<Character> iToaLst = new ArrayList<>();
        ArrayList<Integer> inLst = cToitran(w);

        for(int i=0; i<cToitran(w).size(); i++) {
            int integer = inLst.get(i);
            char ch = (char) integer;
            iToaLst.add(ch);
        }
        return iToaLst;


    }

    public static String join(String w) {
        /**
         * 아스키코드 -> 최종 반환 스트링 변환
         */
        ArrayList<Character> chr = iToCtran(w);
        StringBuilder sb = new StringBuilder();
        for(char ch : chr) {
            sb.append(ch);
        }
        String str = sb.toString();

        return str;
    }


    public static ArrayList<Character> characterArr(String s) {
        /**
         * 인풋 스트링 캐릭터 변환
         */
        ArrayList<Character> characters = new ArrayList<>();

        for(int i=0; i<s.length(); i++) {
            characters.add(s.charAt(i));
        }
        return characters;
    }
}
