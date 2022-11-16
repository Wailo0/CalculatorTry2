package calc;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] mathOp = {"+", "-", "/", "*"};
        String[] mathOpReg = {"\\+", "-", "/", "\\*"};
        Scanner ex = new Scanner(System.in);
        System.out.print("Введите пример: ");
        String lat = ex.nextLine();
        String lat2 = lat.replaceAll("\\s+", "");

        if (!lat.contains(" ")) {
            System.out.println("Неккоректно");
            return;
        }

        int inChis = -1;
        for (int i = 0; i < mathOp.length; i++) {
            if (lat.contains(mathOp[i])) {
                inChis = i;
                break;
            }
        }
        if (inChis == -1) {
            System.out.println("Не тот знак вычисления");
            return;
        }

        String[] eachLt = lat2.split(mathOpReg[inChis]);
        if (eachLt.length == 2) {
            if (converter.Rome(eachLt[0]) == converter.Rome(eachLt[1])) {
                int z = 10;
                int a;
                int b;
                boolean Rome = converter.Rome(eachLt[0]);
                if (Rome) {
                    a = converter.romanToInt(eachLt[0]);
                    b = converter.romanToInt(eachLt[1]);
                } else if ((Character.isDigit(eachLt[0].charAt(0))) && (Character.isDigit(eachLt[1].charAt(0)))) {

                    a = Integer.parseInt(eachLt[0]);
                    b = Integer.parseInt(eachLt[1]);

                } else {
                    System.out.println("Это не арабские и не римские цифры");
                    return;
                }
                if (a <= z && b <= z) {
                    int result = switch (mathOp[inChis]) {
                        case "+" -> a + b;
                        case "-" -> a - b;
                        case "/" -> a / b;
                        default -> a * b;
                    };
                    if (Rome) {
                        if (result < 0) {
                            System.out.println("В римской системе счисления нет нуля и отрицательных чисел");
                        } else {
                            System.out.println(converter.intToRoma(result));
                        }

                    } else {
                        System.out.println(result);
                    }
                } else if (a >= z && b >= z) {
                    System.out.print("Числа больше 10");
                } else {System.out.println("Введите корректный числа");}
            } else System.out.println("Разные системы счисления");
        } else System.out.println("Больше или меньше элементов");
    }
}



