package onboarding;

class Word {

  private String word;
  private static final int MINLIMIT = 1;
  private static final int MAXLIMIT = 1000;

  Word(String word) {
    lengthValidityCheck(word);
    this.word = word;
  }

  private void lengthValidityCheck(String word) {
    if (word.length() < MINLIMIT || word.length() > MAXLIMIT) {
      throw new IllegalArgumentException("length of word is not in range.");
    }
  }

  String getAnswer() {
    Classifier classifier = new Classifier(word);
    return classifier.getChangedString();
  }
}

class Classifier {

  private StringBuffer answer;
  private static final int UPPERSUM = 'A' + 'Z';
  private static final int LOWERSUM = 'a' + 'z';
  private static final int ISUPPERCASE = 0;
  private static final int ISLOWERCASE = 1;
  private String classifier;

  Classifier(String word) {
    this.classifier = word;
  }

  String getChangedString() {
    StringBuilder sb = new StringBuilder();
    char chunk;
    for (int i = 0; i < classifier.length(); i++) {
      int classifyId = checkUpperLowerElse(classifier.charAt(i));
      sb.append(changeChunk(classifyId, classifier.charAt(i)));
    }
    return sb.toString();
  }

  int checkUpperLowerElse(char chunk) {
    if (chunk >= 'a' && chunk <= 'z') {
      return ISLOWERCASE;
    }
    if (chunk >= 'A' && chunk <= 'Z') {
      return ISUPPERCASE;
    }
    return 2;
  }

  char changeChunk(int Id, char chunk) {
    if (Id == ISLOWERCASE) {
      return (char) (LOWERSUM - chunk);
    }
    if (Id == ISUPPERCASE) {
      return (char) (UPPERSUM - chunk);
    }
    return chunk;
  }
}

public class Problem4 {

  public static String solution(String word) {
    Word inputWord = new Word(word);
    return (inputWord.getAnswer());
  }
}
