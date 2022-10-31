package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);

        while(true){
            // 문자가 빈 문자열일 경우 종료
            if(sb.toString().equals("")) break;

            ArrayList<Integer> indexArr = new ArrayList<>(); // 연속문자 시작 인덱스 저장
            ArrayList<Integer> cntArr = new ArrayList<>(); // 연속문자 연속개수 저장

            int index=0, cnt=0; // 연속문자 시작 인덱스, 개수 저장 변수
            char preChar=' '; // 이전 문자 저장 변수
            boolean check=false; // 연속문자 여부 check
            for(int i=0;i<sb.length();i++){
                if(preChar==sb.charAt(i)){ // 이전문자와 같은 경우
                    check=true;
                    cnt++;
                } else{ // 이전문자와 다른 경우
                    if(check){ // 연속문자 여부가 true인 경우 index, cnt 저장
                        indexArr.add(index);
                        cntArr.add(cnt);
                    }
                    check=false;
                    preChar=sb.charAt(i); // 이전문자 갱신
                    index=i; // 인덱스 갱신
                    cnt=1; // 연속개수 변수 1로 초기화
                }
            }
            if(check){ // check가 true인 경우 index, cnt 저장
                indexArr.add(index);
                cntArr.add(cnt);
            }
            // 연속문자가 없을 경우 종료
            if(indexArr.size()==0) break;

            // 문자열 char배열로 만들기
            char[] charArr = sb.toString().toCharArray();
            sb = new StringBuilder("");
            for(int i=0;i<charArr.length;i++){
                boolean checkIndex=true; // 해당 문자가 연속문자 인덱스 여부 check
                // 모든 List 순회하면서 해당 인덱스가 List에 존재하면 false후 break.
                for(int j=0;j<indexArr.size();j++){
                    if(indexArr.get(j)<=i && i<=indexArr.get(j)+cntArr.get(j)-1){
                        checkIndex=false;
                        break;
                    }
                }
                if(checkIndex){ // true일 경우에만 해당 문자 추가
                    sb.append(charArr[i]);
                }
            }
        }

        String answer = sb.toString();
        return answer;
    }
}
