import java.util.TreeMap;

class ToRomanConverter {
    TreeMap<Character, Integer> romanNumbers = new TreeMap<>();
    TreeMap<Integer, String> arabianNumbers = new TreeMap<>();

    public ToRomanConverter() {
        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);

        arabianNumbers.put(1, "I");
        arabianNumbers.put(5, "V");
        arabianNumbers.put(10, "X");
        arabianNumbers.put(50, "L");
        arabianNumbers.put(100, "C");
    }

    public boolean isRoman(String numbers) {
        return romanNumbers.containsKey(numbers.charAt(0)) ;
    }

    public String arabToRoman(int data) {
        String roman = "";
        int arabKey;
        while (data != 0) {
            arabKey = arabianNumbers.floorKey(data);
            roman += arabianNumbers.get(arabKey);
            data -= arabKey;
        }
        return roman;
    }

    public int romanToArab(String roman) {
        char[] romanArray = roman.toCharArray();
        int result = romanNumbers.get(romanArray[roman.length() - 1]);
        for (int i = roman.length() - 2; i >= 0; i--) {
            int arab = romanNumbers.get(romanArray[i]);

            if (arab < romanNumbers.get(romanArray[i + 1])) {
                result -= arab;
            } else {
                result += arab;
            }
        }
        return result;
    }
}
