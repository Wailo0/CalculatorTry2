package Main;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws Error {

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите арифм.выражение в виде: a + b, a - b, a / b, a * b: ");
        String mathVyr = scan.nextLine();
        mathVyr = mathVyr.replaceAll("\\s+", "");
        System.out.println(calculate(mathVyr));
    }


        public static String calculate (String mathVyr) {
            String results;
            Check check = new Check();
            int inOp = -1;

            for (int i = 0; i < check.opMass.length; i++) {
                if (mathVyr.contains(check.opMass[i])) {
                    inOp = i;
                    break;
                }
            }
            if (inOp == -1) {
                throw new Error("Неккоректный ввод");
            }

            String [] eachNumb = mathVyr.split(check.opMassReg[inOp]);
            check.toInt(eachNumb);
            if (eachNumb.length != 2){
                throw new Error("Неккоректный пример, вводите по шаблону");
            }

            int a = check.a1;
            int b = check.b1;
            int result = switch (check.opMass[inOp]){
                case "+" -> a + b;
                case "-" -> a - b;
                case "/" -> a / b;
                default -> a * b;
            };

            String res = Integer.toString(result);
            results = check.intToRome(res);
            return results;
        }

}