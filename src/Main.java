import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static boolean isRome = false;

    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       String expression = sc.nextLine();
       System.out.println(calc(expression));

    }

    public static String calc(String expression) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "I");
        map.put("2", "II");
        map.put("3", "III");
        map.put("4", "IV");
        map.put("5", "V");
        map.put("6", "VI");
        map.put("7", "VII");
        map.put("8", "VIII");
        map.put("9", "IX");
        map.put("10", "X");

        String[] splitExpression = expression.split(" ");
        if(splitExpression.length > 3) {
            throw new NumberFormatException();
        }
        String fDigit = splitExpression[0].trim();
        String operand = splitExpression[1].trim();
        String sDigit = splitExpression[2].trim();

        int totalDigit1 = 0;
        int totalDigit2 = 0;

        if(checkNums(map, fDigit, sDigit) == 1) {
            totalDigit1 = toArabic(fDigit);
            totalDigit2 = toArabic(sDigit);
        } else if(checkNums(map, fDigit, sDigit) == 2){
            totalDigit1 = Integer.parseInt(fDigit);
            totalDigit2 = Integer.parseInt(sDigit);
        } else {
            throw new NumberFormatException();
        }


        if(operand.equals("+")) {
            int sum = totalDigit1 + totalDigit2;
            if(isRome) {
                if (sum < 0 || sum == 0 || sum > 10) {
                    throw new NumberFormatException();
                } else {
                    String v = Integer.toString(sum);
                    return map.get(v);
                }
            } else {
                return Integer.toString(totalDigit1 + totalDigit2);
            }
        } else if(operand.equals("-")) {
            int raz = totalDigit1 - totalDigit2;
            if(isRome) {
                if (raz < 0 || raz == 0) {
                    throw new NumberFormatException();
                } else {
                    String v = Integer.toString(raz);
                    System.out.println(map.get(v));
                }
            } else {
                System.out.println(totalDigit1 - totalDigit2);
            }
        } else if(operand.equals("*")) {
            int mult = totalDigit1 * totalDigit2;
            if(isRome) {
                if (mult == 0 || mult > 10) {
                    throw new NumberFormatException();
                } else {
                    String v = Integer.toString(mult);
                    System.out.println(map.get(v));
                }
            } else {
                System.out.println(totalDigit1 * totalDigit2);
            }
        } else if(operand.equals("/")) {
            int div = totalDigit1 / totalDigit2;
            if(isRome) {
                if (div == 0) {
                    throw new NumberFormatException();
                } else {
                    String v = Integer.toString(div);
                    System.out.println(map.get(v));
                }
            } else {
                System.out.println(totalDigit1 + totalDigit2);
            }
        } else {
            throw new NumberFormatException();
        }
        return null;
    }


    public static int checkNums(Map<String, String> map, String fDigit, String sDigit) {
        if(map.containsKey(fDigit) && map.containsKey(sDigit) || fDigit.matches("[-+]?\\d+") || sDigit.matches("[-+]?\\d+")) {
            isRome = false;
            return 2;
        } else if(map.containsValue(fDigit) && map.containsValue(sDigit)) {
            isRome = true;
            return 1;
        } else {
            throw new NumberFormatException();
        }
    }

    public static int toArabic(String value){
        if(value.equals("I")) {
            return 1;
        } else if(value.equals("II")) {
            return 2;
        } else if(value.equals("III")) {
            return 3;
        } else if(value.equals("IV")) {
            return 4;
        } else if(value.equals("V")) {
            return 5;
        } else if(value.equals("VI")) {
            return 6;
        } else if(value.equals("VII")) {
            return 7;
        } else if(value.equals("VIII")) {
            return 8;
        } else if(value.equals("IX")) {
            return 9;
        } else if(value.equals("X")) {
            return 10;
        } else {
            return 0;
        }
    }

}
