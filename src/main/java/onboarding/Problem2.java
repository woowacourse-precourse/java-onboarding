package onboarding;

public class Problem2 {

    private StringBuffer cryptograph = new StringBuffer();
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private boolean isHappenedDecryption(){

        if(findDecodedSection()){
            deleteFoundSection();
            return true;
        }else{
            return false;
        }
    }

    private  boolean findDecodedSection(){
        int cryptogramLength = cryptograph.length();
        boolean existence = false;

        for( int standardIdx=0 ; standardIdx<(cryptogramLength-1) ; standardIdx++){
            for( int comparisonIdx=standardIdx+1 ; comparisonIdx<cryptogramLength ; comparisonIdx++){

                if(isDifferentCharacters(standardIdx,comparisonIdx)){
                    if(isExistSameCharactersBetween(standardIdx,comparisonIdx)){
                        existence = true;
                        checkXToBeDecodedSection(standardIdx,comparisonIdx);
                        standardIdx = comparisonIdx-1;
                    }
                    break;
                }

            }
        }

        return existence;
    }

    private boolean isDifferentCharacters(int standardIdx,int comparisonIdx){
        return cryptograph.charAt(standardIdx)!=cryptograph.charAt(comparisonIdx);
    }
    private boolean isExistSameCharactersBetween(int standardIdx,int comparisonIdx){
        return (comparisonIdx-standardIdx)>1;
    }

    private void checkXToBeDecodedSection(int startPoin,int EndNextPoint){
        for(int i=startPoin;i<EndNextPoint;i++){
            cryptograph.setCharAt(i,'X');
        }
    }

    private void deleteFoundSection(){
        String decryptedCryptograph = cryptograph.toString().replace("X","");
        cryptograph = new StringBuffer(decryptedCryptograph);
    }
}
