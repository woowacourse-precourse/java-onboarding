
package onboarding;
import java.util.ArrayList;

/*
cryptogram.charAt(i)와 cryptogram.charAt(i+1)만 지우게 해서 aabbcdeff같은 예외를 처리하지 못해 다시 풀었습니다.
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        ArrayList<Character> arrayList = new ArrayList<>();

        for(char alphabet : cryptogram.toCharArray()) arrayList.add(alphabet);

        while(!remove_overlap(arrayList));

        StringBuilder answer = new StringBuilder();
        for(char word : arrayList) answer.append(word);

        return answer.toString();
    }

        private static boolean remove_overlap(ArrayList<Character> check_list){
            boolean list = true;
//            System.out.println("check_list : " + check_list);
            // 배열을 돌며 중복을 삭제해준다. 중복이 있다면 i--를 통해 삭제 후 그 자리를 다시 체크한다.
            for(int alphabet_index = 0; alphabet_index < check_list.size() - 1; alphabet_index++){
//                System.out.println("check_list : " + check_list + "alphabet_index : " + alphabet_index);
                if(check_list.get(alphabet_index) == check_list.get(alphabet_index+1)){
                    list = false;
                    char c = check_list.get(alphabet_index);
                    while(alphabet_index+1 < check_list.size() && c == check_list.get(alphabet_index+1))
                        check_list.remove(alphabet_index+1);
                    check_list.remove(alphabet_index); //자신과 연속으로 중복되는 i들을 삭제하고 자신을 삭제한다.
                    alphabet_index--;
                }
            }
            return list;
        }


    }