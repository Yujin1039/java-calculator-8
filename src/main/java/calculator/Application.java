package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        System.out.println("결과 : "+sum(str));
    }

    private static int sum(String str){
        int total = 0;

        String[] calStr = getSeparator(str);
        String[] numArr = calStr[1].split("[,:"+calStr[0]+"]");

        for(String s: numArr){
            total += Integer.parseInt(s);
        }

        return total;
    }

    private static String[] getSeparator(String str){
        String[] tempArr = str.split("//|\\\\n");
        String addedSep = "";
        String trimmedStr = tempArr[0];

        if(tempArr.length == 3 && !tempArr[1].isEmpty()){
            addedSep = tempArr[1];
            trimmedStr = tempArr[2];
        }

        String[] chkSepArr = trimmedStr.split("["+addedSep+",:0-9]");
        for (String s : chkSepArr) {
            if (!s.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }

        String[] trimmedArr = {addedSep, trimmedStr};
        return trimmedArr;
    }
}
