package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        String[] temp = new String[forms.size()];

//이메일 형식에 부합하는지 확인하는 과정
        for(int i = 0; i < forms.size(); i++){
            if(checkEmail(forms.get(i).get(0)) == false){
                answer = List.of("Wrong input");
                System.out.println("Wrong input");
                return answer;
            }
        }

        int index  = 0;
        int[] resultIndex = new int[forms.size()];

//-1로 resultIndex초기화
        for(int i = 0; i <forms.size(); i++){
            resultIndex[i] = -1;
        }

        for(int i = 0; i < temp.length; i++){
            temp[i] = forms.get(i).get(1);
        }
        for(int i = 0; i < temp.length; i++){
            for(int j = i+1; j< temp.length; j++){
                int check = compareWord(temp[i],temp[j]); // 1이면 서로 중복되는 단어가 있음.
                if( check == 1){
                    if( resultIndex[i] == -1 ) {
                        resultIndex[i] = i;
                    }
                    if( resultIndex[j] == -1 ) {
                        resultIndex[j] = j;
                    }
                    index+=1;
                }
            }
        }
        int answerLen = 0;
        for(int i = 0; i < resultIndex.length; i++){
            if(resultIndex[i] != -1){
                answerLen += 1;
            }
        }
        if(answerLen != 0) {
            String[] tempAnswer = new String[answerLen];
            int j = 0;
            for(int i = 0; i < resultIndex.length; i++) {
                if(resultIndex[i] != -1) {
                    tempAnswer[j] = forms.get(resultIndex[i]).get(0);
                    j += 1;
                }
            }
            answer = List.of(tempAnswer);;
        }
        else{
            answer = List.of(" ");
        }

        return answer;
    }
//이름을 char형으로 분리해서 중복되는 글이 있는지 확인하는 함수.
    public static int compareWord (String list_pre, String list_next) {
        char[] nameList_pre = new char[list_pre.length()];
        char[] nameList_next = new char[list_next.length()];
        for(int i = 0; i < list_pre.length(); i++){
            nameList_pre[i] = list_pre.charAt(i);
        }
        for(int i = 0; i < list_next.length(); i++){
            nameList_next[i] = list_next.charAt(i);
        }

        for(int i = 0; i < nameList_pre.length; i++){
            for(int j = 0; j< nameList_next.length; j++){
                if(nameList_pre[i] == nameList_next[j]){
                    if(i+1 < nameList_pre.length  && j+1 <nameList_next.length) {
                        if (nameList_pre[i + 1] == nameList_next[j + 1]) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 0;
    }

//이메일 형식을 확이하는 함수
    public static boolean checkEmail(String email){
        int atPoint = 0;
        String[] emailForm = email.split("@");
        if (email.length() < 11 || email.length() >20 ) {
            return false;
        }
        for(int i = 0; i < email.length(); i++){
            if(email.charAt(i) == '@') {
                atPoint = i;
            }
        }
        if(atPoint == 0){
            return false;
        }

        if(emailForm[1].compareTo("email.com") != 0 ){
            return false;
        }
        return true;
    }

}
