package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        char[] cryptoArr = cryptogram.toCharArray();

        int prevIdx = 0;
        int currentIdx = 0;

        for (currentIdx = 1; currentIdx < cryptoArr.length; currentIdx++) {
            if (cryptoArr[currentIdx - 1] != cryptoArr[currentIdx]) {
                cryptoArr[prevIdx++] = cryptoArr[currentIdx - 1];
            } else {
                //두 word만 남았을 경우 while문에서 ArrayIndexOutOfBoundsException 가 발생했는데
                //두개만 남았을 경우 0번째와 1번째 인덱스가 같다면 굳이 for문 뒷부분이 실행될 필요가 없음
                if(cryptoArr.length == 2 && cryptoArr[0] == cryptoArr[1])
                    return answer = "";
                while (currentIdx < cryptoArr.length && cryptoArr[currentIdx - 1] == cryptoArr[currentIdx])
                    currentIdx++;
            }
        }

        cryptoArr[prevIdx++] = cryptoArr[currentIdx - 1]; // 마지막부분이 빠지기 때문에 넣어줌

        answer = new String(cryptoArr).substring(0, prevIdx); // prevIdx를 사용해서 중복제거한 새 단어를 만듬

        if(prevIdx != cryptoArr.length)
            return solution(answer);

        return answer;
    }
}
