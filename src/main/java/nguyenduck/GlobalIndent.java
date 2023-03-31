package nguyenduck;

public class GlobalIndent {
    public static Integer value = 0;

    public static void add() {
        value++;
    }

    public static void del() {
        value--;
    }

    public static String get() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }

    public static void reset() {
        value = 0;
    }
}
