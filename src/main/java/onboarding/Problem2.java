package onboarding;

import java.util.ArrayList;

public class Problem2 {

    //ArrayList<Character> 형태로 들어오는 input에서 같은 단어가 중복돼서 연결된 경우를 제거해주는 함수.
    public static boolean delete_overlap(ArrayList<Character> input){
        //입력으로 들어오는 arrayList에서 중복값을 제거하는 경우가 없으면 true를 리턴, 중복값을 제거하는 기능을 했다면 false를 리턴.
        boolean flag = true;

        for(int i=0; i<input.size()-1; i++){
            //i번째 문자와 i+1번째 문자가 같은 문자라면
            if(input.get(i) == input.get(i+1)){
                flag = false;
                char c = input.get(i);
                //arrayList범위를 벗어나지 않으면서, i번째와 다른 문자가 i+1번째에 올때까지 i+1번째 문자를 계속 지운다
                while(i+1 < input.size() && c == input.get(i+1))
                    input.remove(i+1);
                //그 다음에 i번째 문자도 마저 지운다.
                input.remove(i);
                //인덱스는 1 감소시키고 arrayList를 마저 탐색한다.
                i -= 1;
            }
        }

        return flag;
    }

    public static String solution(String cryptogram) {
        //입력으로 들어오는 String을 ArrayList<Character>형태로 변환.
        ArrayList<Character> arrayList = new ArrayList<>();
        for(char c : cryptogram.toCharArray()){
            arrayList.add(c);
        }

        //delete_overlap함수를 실행했을때, 중복문자를 제거하는 경우가 없을때까지 계속 반복수행.
        //중복문자를 제거하는 경우는 false를 반환해서 while문이 계속 돌지만, 중복문자를 제거할것이 없어서 true를 반환하면 while문 탈출
        while(delete_overlap(arrayList) == false);

        //최종 정답을 ArrayList<Character>에서 String으로 변환하여 반환한다.
        String answer = "";
        for(char c : arrayList)
            answer += c;
        return answer;
    }
}
