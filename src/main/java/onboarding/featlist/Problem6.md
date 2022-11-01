# Problem-6

## Explanation
- 중복된 부분 이름이 있을 경우 그 이메일을 추가한다.

## Function
### Interface

### Class
1. `CrewCalculator implements Calculator`
   - 중복된 이름이 있는지 확인하고 그 이메일을 반환한다.

### Enum
1. `Crew`
   - 이메일과 이름의 위치를 저장한다.

### Method
1. `List<Integer> calculation()`
   - 중복된 부분 이름이 있을 경우 그 이메일을 반환한다.
2. `List<String> subName(String)`
   - 이름에서 두 자리 이상의 부분 문자열을 구해 리스트로 반환한다.
3. `void isSizeTwoOrMor(String, int, int, List<String>)`
   - 나머지를 계산해 반환한다.
4. `void makeSnList(List<String>)`
   - 각 이름에서 부분 문자열을 구한다.
5. `void makeCount(Map<String, Integer>)`
   - 구해진 부분 문자열로 개수를 센다.
6. `void partition(List<String>, Map<String, Integer>)`
   - 부분 문자열의 개수를 Map에 저장한다.
4. `void makeAnswer(List<List<String>>, Map<String, Integer>, answer)`
   - 부분 문자열의 길이가 2 이상일 경우 정답에 추가한다.

### Parameter
