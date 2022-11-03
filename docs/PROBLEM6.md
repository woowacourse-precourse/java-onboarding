# [Problem 6](https://www.notion.so/6-24d85fe50cd7480ebdb40154de1db510) 기능별 명세

## 1. public static Map<String, String> listToMap(List<List<String\>> forms) {}

### input
- **List<List<String\>> forms**
  (이메일, 닉네임)의 쌍으로 이루어진 정보가 각 크루별로 리스트에 저장되어 있으며, 이 리스트들을 저장하고 있는 리스트가 forms.

### output
- **(Map<String, String\>)** 이중 리스트 형태의 데이터를 key가 닉네임, value가 이메일인 Map 데이터로 변환한 결과.
- 
### 기능 상세
이메일과 닉네임 한 쌍이 한 명의 크루에 대한 정보이므로 리스트 데이터로서 이메일은 인덱스 0, 닉네임은 인덱스 1로 접근하기보다</br>
닉네임을 key 값으로, 이메일을 value 값으로 하는 Map으로 변환해 사용하는 것이 편하고 직관적입니다.</br>
이를 위해 문제에서 주어지는 List<List<String\>> 타입 데이터 forms를 Map으로 변환하는 기능을 하는 메소드입니다.

## 2. public static List<String\> validateEmailPattern(Map<String, String> forms) {}

### input
- **Map<String, String\> forms**
  key를 닉네임, value를 이메일로 하여 저장된 각 크루들의 Map 데이터.

### output
- **(List<String\>)** 문제에서 주어진 조건에 부합하지 않는 이메일 형식들을 저장한 리스트.

### 기능 상세
forms 내 데이터 중 이메일들이 문제에서 주어진 조건에 부합하는지 확인하는 기능을 합니다. 만족시켜야 하는 이메일 형식은 다음과 같습니다.
- 기본적인 이메일의 형식을 지켜야 합니다.
- 전체 길이가 11자 이상 20자 미만이어야 합니다.
- 이메일의 도메인 email.com이어야 합니다.
위 조건에 맞추어 컴파일한 패턴과 이메일과의 매칭 여부를 파악하고, 매칭되지 않는 이메일들을 저장한 리스트를 반환합니다.

## 3. public static List<String\> validateNicknamePattern(Map<String, String>){}

### input
- **Map<String, String> forms**
  key를 닉네임, value를 이메일로 하여 저장된 각 크루들의 Map 데이터.

### output
- **(List<String\>)** 중복이 발생한 크루들의 닉네임을 정렬하여 저장한 리스트.

### 기능 상세
닉네임의 형식 준수와 중복 발생 여부를 확인하고, 중복이 발생한 크루들의 이메일 데이터를 반환하는 기능을 합니다.</br>
다음은 validateNicknamePattern()의 기능 수행을 위해 사용되는 메소드들의 목록입니다.</br>
- 3-2. public static Pattern composeNicknamePattern(String nickname, int chunkIdx){}
  - input
    - **String nickname**
      전체 닉네임의 리스트에서 하나씩 가져온 닉네임.
    - **int chunkIdx**
      nickname을 연속 두 글자씩 추출해 chunk를 만들 때, 그 chunk의 시작 인덱스. validateNicknamePattern()에서 1씩 증가시켜가며 호출합니다.
  - output 
    - **(Pattern)** 닉네임이 갖춰야 할 형식을 반영한 패턴.
  - 기능 상세
    정규식을 사용해서 정해진 형식에 맞는 닉네임의 패턴을 만드는 기능을 합니다. 문제에서 조건으로 주어진 닉네임 형식은 다음과 같습니다.</br>
    - 한글만 사용.
    - 1자 이상, 20자 미만
    
- 3-3. public static List<String\> findDuplicatedNickname(List<String\> nicknameList, int index) {}
  - input
    - **List<String\> nicknameList**
      크루들의 전체 닉네임이 저장된 리스트.
    - **int index**
      nicknameList 내 데이터 중 현재 검증하고자 하는 닉네임의 인덱스.
  - output
    **(List<String\>)**
      nicknameList.get(index)와 중복이 존재하는 닉네임들을 저장한 리스트.
    - 기능 상세
      파라미터로 받은 인덱스의 닉네임과 중복되는 닉네임들을 구하는 기능을 합니다.</br>
      중복 여부를 확인하기 위해 nicknnameList.get(index)의 반환 값인 nickname로 만들 수 있는 연속 두 글자의 모든 경우의 수를 패턴으로 만들고,</br>
      nicknameList 내의 다른 닉네임 중에 해당 패턴에 부합하는(중복되는) 닉네임이 있다면 리스트에 저장해 반환합니다.

validateNicknamePattern()은 nicknameList 내 모든 원소들에 대해 findDuplicatedNickname()을 호출해서 중복을 확인하고,</br>
그렇게 도출한 중복 닉네임들에 대응되는 이메일 값을 찾아 duplicatedCrewEmail에 모두 저장합니다.</br>
중복 제거와 정렬을 마친 후 이를 반환합니다.














