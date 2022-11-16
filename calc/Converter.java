package calc;

import java.util.TreeMap;


public class Converter {
    TreeMap<Character, Integer> romaMap = new TreeMap<>();
    TreeMap<Integer, String> arabKeyMap = new TreeMap<>();

    public Converter() {
        romaMap.put('I', 1);
        romaMap.put('V', 5);
        romaMap.put('X', 10);
        romaMap.put('L', 50);
        romaMap.put('C', 100);

        arabKeyMap.put(100, "C");
        arabKeyMap.put(90, "XC");
        arabKeyMap.put(50, "L");
        arabKeyMap.put(40, "XL");
        arabKeyMap.put(10, "X");
        arabKeyMap.put(9, "IX");
        arabKeyMap.put(5, "V");
        arabKeyMap.put(4, "IV");
        arabKeyMap.put(1, "I");
    }

    public boolean Rome(String number) {
        return romaMap.containsKey(number.charAt(0));
    }

    public String intToRoma(int number) {

            String roman = "";
            int arabianKey;
            do {
                arabianKey = arabKeyMap.floorKey(number);
                roman += arabKeyMap.get(arabianKey);
                number -= arabianKey;
            } while (number != 0);
            return roman;
    }

    public int romanToInt(String s){
            int end = s.length() - 1;
            char[] arr = s.toCharArray();
            int arabian;
            int result = romaMap.get(arr[end]);
            for (int i = end - 1; i >= 0; i--) {
                arabian = romaMap.get(arr[i]);

                if (arabian < romaMap.get(arr[i + 1])) {
                    result -= arabian;
                } else {
                    result += arabian;
                }
            }
            return result;
    }
}
