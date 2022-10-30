
package onboarding;
import java.util.ArrayList;

/*
cryptogram.charAt(i)와 cryptogram.charAt(i+1)만 지우게 해서 aabbcdeff같은 예외를 처리하지 못해 다시 풀었습니다.
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        ArrayList<Character> arrayList = new ArrayList<>();

        for(char c : cryptogram.toCharArray()) arrayList.add(c);

        while(!remove_overlap(arrayList));

        String answer = "";
        for(char c : arrayList) answer += c;

        return answer;
    }

    //
        public static boolean remove_overlap(ArrayList<Character> check_list){
            boolean list = true;

            for(int i=0; i<check_list.size()-1; i++){
                System.out.println("i1 : " + i);
                if(check_list.get(i) == check_list.get(i+1)){
                    list = false;
                    char c = check_list.get(i);
                    while(i+1 < check_list.size() && c == check_list.get(i+1))
                        check_list.remove(i+1);
                    check_list.remove(i);
                    System.out.println("i : " + i);
                    i--;
                }
            }

            return list;
        }


    }