package onboarding;

import javax.management.StringValueExp;
import java.util.*;

public class Problem6 {

   static List<String> overlapNickname = new ArrayList<>();


    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");


        String[] name = outputNickname(forms);
        String[] out = new String[2];
        StringBuffer sf = new StringBuffer();
        boolean[] visited = new boolean[name.length];
        int start = 0;
        permutation(name, out, name.length, sf, visited, 0,0, 0);

        String s = sf.toString();



        return answer;

    }

    public static void permutation(String [] name, String [] out, int nameLength, StringBuffer sf, boolean [] visited, int cnt, int a, int start){
        if(cnt == 2){
             a = 0;
             cnt = 0;
            for(int k = 0; k< out.length-1; k++) {
                String first = out[k];
                String second = out[k+1];
                List<String> arrprevWord = new ArrayList<>();
                List<String> arrnextWord = new ArrayList<>();
                for (int i = 0; i < first.length() - 1; i++) {

                    String ch1 = String.valueOf(first.charAt(i));
                    String ch2 = String.valueOf(first.charAt(i+1));
                    arrprevWord.add(ch1+ch2);

                }
                for (int i = 0; i < second.length() - 1; i++) {

                    String c1 = String.valueOf(second.charAt(i));
                    String c2 = String.valueOf(second.charAt(i+1));
                    arrnextWord.add(c1+c2);
                }
                int u = 0;
                while(u<arrnextWord.size()){
                    if(!arrprevWord.equals(arrnextWord)){
                        if (arrprevWord.contains(arrnextWord.get(u))) {
                            sf.append(first);
                            sf.append(",");
                            sf.append(second);
                            sf.append(",");

                        }
                    }
                    u++;

                }

                arrprevWord.clear();
                arrnextWord.clear();
            }
            out = new String[2];
            return;

        }
        for(int i = 0; i< nameLength; i++ ){
            if(!visited[i]){
                visited[i] = true;
                out[a]=name[i];
                permutation(name, out, nameLength, sf, visited, cnt+1, a+1, start);
                visited[i] = false;
                return;
            }

        }

    }


    public static String[] outputNickname(List<List<String>> forms) {
        StringBuffer a = new StringBuffer();
        for (int i = 0; i < forms.size(); i++) {
            for (int j = 1; j < forms.get(i).size(); j++) {
                a.append(forms.get(i).get(j));
                a.append(",");

            }
        }
        String str2 = a.toString();
        return str2.split(",");
    }
}






    /*public static List<String> test(List<List<String>> test) {

        String[] nickname = outputNickname(test);
        List<String> arrprevWord = new ArrayList<>();
        List<String> arrnextWord = new ArrayList<>();
        List<String> overlapNickname = new ArrayList<>();
    }


}

     */




       /* int prevCount = -1;
        int nextCount = 1;
        int untilNextCount;
        String nextWord = "";
        String standardComparisonWord = "";
        untilNextCount = nickname.length-1;
        //비교기준 단어리스트
        do{
            arrprevWord = new ArrayList<>();
            standardComparisonWord = standardComparisonWord(nickname, prevCount + 1);
            arrprevWord = arrPrevWordSplit(nickname,prevCount+1);

            while (untilNextCount != 1){
                arrnextWord = new ArrayList<>();
                nextWord = otherWord(nickname,nextCount);
                arrnextWord = arrNextvWordSplit(nickname,nextCount);
                nextCount++;
                if (arrnextWord.contains(standardComparisonWord)&&checkArr(overlapNickname,standardComparisonWord,nextWord)) {
                    overlapNickname = new ArrayList<>();
                    overlapNickname.add(standardComparisonWord);
                    overlapNickname.add(nextWord);
                }

                untilNextCount--;
            };
            prevCount++;
            untilNextCount = nickname.length - prevCount;
        }while (prevCount != nickname.length-1);




        return overlapNickname;
    }


    public static String[] outputNickname(List<List<String >> forms){
        StringBuffer a = new StringBuffer();
        for (int i = 0; i < forms.size(); i++) {
            for (int j = 1; j < forms.get(i).size(); j++) {
                a.append(forms.get(i).get(j));
                a.append(",");

            }
        }
        String str2 = a.toString();
        return str2.split(",");
    }

    public static String standardComparisonWord(String [] nickname, int num){
        return nickname[num];
    }

    public static ArrayList<String> arrPrevWordSplit (String [] nickname, int num){
        String word = standardComparisonWord(nickname, num);
        ArrayList<String> arrPrevWordSplit = new ArrayList<>();
        for (int i = 0; i < word.length()-1; i++) {
            char ch1 = word.charAt(i);
            char ch2 = word.charAt(i + 1);
            arrPrevWordSplit.add(String.valueOf(ch1 + ch2));
        }
        return arrPrevWordSplit;
    }

    public static String otherWord(String [] nickname, int num){
        return nickname[num];
    }

    public static List<String> arrNextvWordSplit (String [] nickname, int num){
        String word = otherWord(nickname,num);
        List<String> arrNextWordSplit = new ArrayList<>();
        for (int i = 0; i < word.length()-1; i++) {
            char ch1 = word.charAt(i);
            char ch2 = word.charAt(i + 1);
            arrNextWordSplit.add(String.valueOf(ch1 + ch2));
        }
        return arrNextWordSplit;
    }

    public static boolean a (String a, String b){
        return a.equals(b);
    }


    public static boolean checkOverlapWord(List<String >prev, List<String>next, String word){
        int a = 0;
        for(int i = 0; i<prev.size();i++) {
            String b = prev.get(i);
            if(next.contains(b)){
                a++;
            }

       }return a >0;
    }

    public static boolean checkArr(List<String> arrnext, ) {
        arrnext = arrNextvWordSplit()
        int input = 0;
        if(total.contains(prev)){
            input = 1;
        }
        if(total.contains(next)){
            input = 1;
        }
        return input != 1 ==true;
    }

    public static boolean overlapNickname(List<String> overlapNickname){
        overlapNickname =
        if(checkArr(overlapNickname,prevWord)){
            overlapNickname.add(prevWord);
        }
        if(checkArr(overlapNickname,nextWord)){
            overlapNickname.add(nextWord);
        }
        return (overlapNickname);
    }

        */







        /*StringBuffer a = new StringBuffer();

        for (int i = 0; i < test.size(); i++) {
            for (int j = 1; j < test.get(i).size(); j++) {
                a.append(test.get(i).get(j));
                a.append(",");

            }
        }
        String str2 = a.toString();
        do {
            //비교기준
            for (int i = 0; i < str3.length - 1; i++) {
                ch1 = str3[i];
                for (int k = 0; k < ch1.length() - 1; k++) {
                    char prev = ch1.charAt(k);
                    char next = ch1.charAt(k + 1);
                    list1.add(String.valueOf(prev + next));
                    for (int g = 1; g < str3.length; g++) {
                        String ch2 = str3[i];
                        for (int q = 0; q < ch2.length() - 1; q++) {
                            char prev2 = ch2.charAt(q);
                            char next2 = ch2.charAt(q + 1);
                            list2.add(String.valueOf(prev2 + next2));
                        }
                        for (int w = 0; w < list1.size(); w++) {
                            if (list2.contains(list1.get(w))) {
                                int index = list2.indexOf(list1.get(w));
                                str5.append(ch1);
                                str5.append(ch2);
                            }

                        }
                        count++;

                    }
                }
            }
            //비교 대상


        }while(count != str3.length);

        return str5.toString();

         */









