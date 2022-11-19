package Main;


import java.util.Arrays;

class Check {
    String[] intMass = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String[] romeMass = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    String[] opMass = {"+", "-", "*", "/"};
    String[] opMassReg = {"\\+", "-", "\\*", "/"};


    enum RomeNumber {
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10),
        XX(20), XXX(30), XL(40), L(50), LX(60), LXX(70), LXXX(80), XC(90), C(100);


        private int a;


        RomeNumber(int a) {
            this.a = a;

        }


        public int getA() {
            return a;
        }
    }

    int a1, b1;
    private String[] numbers;

    public void toInt(String[] numbers) {
        this.numbers = numbers;
        if ((Arrays.asList(romeMass).contains(numbers[0])) && (Arrays.asList(romeMass).contains(numbers[1]))) {
            a1 = RomeNumber.valueOf(numbers[0]).getA();
            b1 = RomeNumber.valueOf(numbers[1]).getA();
        } else if ((Arrays.asList(intMass).contains(numbers[0])) && (Arrays.asList(intMass).contains(numbers[1]))) {
            a1 = Integer.parseInt(numbers[0]);
            b1 = Integer.parseInt(numbers[1]);
        } else {
            throw new Error("Неккоректные вводные данные");
        }
    }

    public String intToRome(String number) {

        int withOst, ost, withOstSt, i1;
        String finalNumber = "";
        i1 = Integer.parseInt(number);

        withOst = (i1 / 10) + 8;
        ost = (i1 % 10) - 1;
        if (Arrays.asList(romeMass).contains(numbers[0])) {
            RomeNumber[] rome = RomeNumber.values();
            if (i1 > 9) {
                if (ost > 0) {
                    finalNumber = rome[withOst].name() + rome[ost].name();
                } else {
                    finalNumber = rome[withOst].name();
                }
            } else if (i1 > 0 & i1 < 10) {
                finalNumber = rome[ost].name();
            }
            else throw new Error("В римских цифрах нет нуля и отрицательных значений");
        } else {
            finalNumber = Integer.toString(i1);
        }
        return finalNumber;
    }
}












            /*if (i1 > 9) {
                if (withOutOst > 0) {
                    finalNumber = rome[withOst].name() + rome[withOutOst].name();
                } else {
                    finalNumber = rome[withOst].name();
                }
            } else if (i1 > 0 & i1 < 10) {
                finalNumber = rome[withOutOst].name();
            } else {
                throw new Error(" В римских цифрах нет нуля, дробей или отрицательных значений");

   /* withOst = (i1 / 10) + 9;
    withOutOst = (i1 % 10) - 1;
    RomeNumber [] rome = RomeNumber.values();
            if (i1 > 9) {
                    if (withOutOst > 0) {
                    finalNumber = RomeNumber[withOst].name() + RomeNumber[withOutOst].name();
                    } else {
                    finalNumber = rome[withOst].name();
                    }
                    } else if (i1 > 0 & i1 < 10) {
        finalNumber = RomeNumber[withOutOst].name();
        } else {
        throw new Error(" В римских цифрах нет нуля, дробей или отрицательных значений");
        } */