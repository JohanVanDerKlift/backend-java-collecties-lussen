import java.util.HashMap;

public class Translator {
    private final HashMap<Integer, String> numericAlpha = new HashMap<Integer, String>();

    public Translator(String[] alphabetic, Integer[] numeric) {
        for (int i = 0; i < alphabetic.length; i++) {
            this.numericAlpha.put(numeric[i], alphabetic[i]);
        }
    }

    public String translate(Integer number) {
        return numericAlpha.get(number);
    }
}
