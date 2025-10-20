# java-calculator-precourse

## 1) 목표
인풋 문자열로부터 기준에 따라 양의 정수를 추출하여 합을 반환하는 프로그램 작성

## 2) 입출력 정의
- **Input**: `camp.nextstep.edu.missionutils.Console.readLine()` 을 이용.
- **Output**: `결과 : <sum>` 형태로 출력.
- **예외로 인한 종료**: `IllegalArgumentException` 을 Throw (`System.exit()` 호출 **금지**  ).

## 3) 추출 규칙
1. **기본 구분자(delimiter)**: comma (`,`) and colon (`:`).
   - 예시: `"" -> 0`, `"1,2" -> 3`, `"1,2,3" -> 6`, `"1,2:3" -> 6`
2. **커스텀 구분자**: `"//<커스텀구분자>\n<숫자>"`
   - 예시: `"//;\n1;2;3" -> 6` (커스텀 구분자는 `;`)
3. **유효 토큰**: 모든 숫자는 **양수** ( > 0 ).
4. **공백**: 일단 trimming 은 고려 X

## 4) 예외 규칙 (`IllegalArgumentException`)
- 음수 등장 시 ( ex: `-1,2`).
- 기본 구분자, 커스텀 구분자를 제외한 입력값 등장 시
- 커스텀 구분 등장 시, 문법을 지키지 않을 시


## 5) Output Format
- 성공 시: `결과 : <sum>`
- 실패 시: throw `IllegalArgumentException`

## 6) 그 외 Constraints
- **JDK 21**.
- **Entry point**: `Application.main(String[] args)`.
- 제공된 **Console API** 사용: `Console.readLine()`.
- **수정 X** `build.gradle`. 외부 라이브러리 X, 제공된 라이브러리만 사용
- **사용 X** `System.exit()`.
