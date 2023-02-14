import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        String[] array = new String[13];
        array[0] = "qwe";
        array[1] = "wqe";
        array[2] = "qwee";
        array[3] = "a";
        array[4] = "a";
        array[5] = "weq";
        array[6] = "qew";
        array[7] = "a";
        array[8] = "weq";
        array[9] = "qwerty";
        array[10] = "werrty";
        array[11] = "ddd";
        array[12] = "ggg";

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            String original = array[i];
            char[] chars = original.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            for (int j = 1; j < array.length; j++) {
                String original2 = array[j];
                char[] chars2 = original2.toCharArray();
                Arrays.sort(chars2);
                String sorted2 = new String(chars2);
                if (sorted.equals(sorted2)) {
                    map.merge(sorted, i + ",", (prev, one) -> prev + one);
                    break;
                }
            }
        }

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String str = entry.getValue();
            int count = (str.split(",", -1).length) - 1;
            if (count < 2) {
                iterator.remove();
            }
        }


        for (Map.Entry<String, String> pair : map.entrySet()) {
            String value = pair.getValue();
            String valueWithoutLasrtSymbol = value.substring(0, value.length() - 1);
            System.out.println(pair.getKey() + " = " + valueWithoutLasrtSymbol);
        }


    }
}
