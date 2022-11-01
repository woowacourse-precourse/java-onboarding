package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        //제거 메서드 호출
        String answer = removeString(cryptogram);
        return answer;
    }

    //인접문자가 같으면 제거하는 기능
    public static String removeString(String cryptogram){
        //추출할 StringBuilder 생성
        StringBuilder sb = new StringBuilder();
        //정답 변수
        String word = "";
        //인스턴스 한글자씩 쪼개기
        String[] arr = cryptogram.split("");
        //처음 글자수
        int initSize = arr.length;
        //sb에 저장되는 횟수
        int count = 0;

        //1글자일때
        if( initSize == 1 ) {
            return cryptogram;
        }else if( initSize == 2 ) { //2글자일때
            //2글자가 서로 같으면 빈문자열 리턴
            if ((arr[0].equals(arr[1]))) {
                return word;
            } else { //2글자인데 서로 다르면 그냥 단어 리턴
                return cryptogram;
            }
        }else { //3글자 이상일때
            //첫 글자와 두번째 글자가 같지않을 경우 첫 글자를 저장
            if (!(arr[0].equals(arr[1]))) {
                sb.append(arr[0]);
                count += 1; //횟수 + 1
            }

            //가운데 문자 반복문
            for (int i = 1 ; i < arr.length - 1 ; i++){
                //인접한 좌, 우 글자에 해당 문자가 없을 경우 글자 저장
                if ( !( arr[i].equals(arr[i-1]) || arr[i].equals(arr[i+1]) ) ) {
                    sb.append(arr[i]);
                    count += 1; //횟수 + 1
                }
            }

            //끝 글자와 이전 글자가 같지않을 경우 끝 글자 저장
            if(!(arr[arr.length - 1].equals(arr[arr.length - 2]))) {
                sb.append(arr[arr.length - 1]);
                count += 1;
            }

            //StringBuilder String 저장
            word = sb.toString();
        }

        return word;
    }
}
