package onboarding;

public class Problem2 {

    public static String removeDuplicateCharacters(String testingString) {

        if(testingString.length() == 0) {
            return testingString;
        }

        char[] testingArray = testingString.toCharArray();
        int index = 0;
        int writingIndex = 0;

        for(index=1; index<testingArray.length; index++)
        {
            //인접한 문자가 같은 시, 문자 제거
            if(testingArray[index] == testingArray[index-1]) {
                while (index<testingArray.length && testingArray[index-1] == testingArray[index]){
                    index++;
                }
            }
            //인접한 문자가 같지 않을 경우, testingArray 배열에 writingIndex 를 이용하여 문자 작성
            else {
                testingArray[writingIndex++] = testingArray[index-1];
            }
        }

        String newString = new String(testingArray).substring(0,writingIndex);

        //중복 제거 완료한 새로운 문자열을 인자로 전달하여 동일한 중복 제거 함수 시행
        if(writingIndex != testingArray.length) {
            return removeDuplicateCharacters(newString);
        }

        //문자열의 길이가 변하지 않았다는 것은 인접한 중복 문자를 모두 제거 완료했다는 의미
        return newString;

    }

    public static String solution(String cryptogram) {
        String answer = removeDuplicateCharacters(cryptogram);
        return answer;
    }
}
