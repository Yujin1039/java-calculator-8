package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
    }

    private static String[] getSepAndExp(String str){
        String[] tempArr = str.split("//|\\\\n");
        String addedSep = "";
        String trimmedStr = tempArr[0];

        // 커스텀 구분자가 존재하는 경우
        if(tempArr.length == 3 && !tempArr[1].isEmpty()){
            addedSep = tempArr[1];
            trimmedStr = tempArr[2];
        }

        // 기타 구분자 존재 여부 확인
        String[] chkSepArr = trimmedStr.split("["+addedSep+",:0-9]");
        for (String s : chkSepArr) {
            if (!s.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }

        // 커스텀 구분자 & 구분자가 포함된 계산식 반환
        String[] trimmedArr = {addedSep, trimmedStr};
        return trimmedArr;
    }
}
