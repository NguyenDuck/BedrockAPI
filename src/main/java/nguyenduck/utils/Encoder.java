package nguyenduck.utils;

import java.nio.charset.StandardCharsets;

public class Encoder {
    public static String utf8ToUnicode(String utf8String) {
        byte[] utf16Bytes = utf8String.getBytes(StandardCharsets.UTF_8);
        String utf16String = bytesToHex(utf16Bytes, "\\u");
        return new String(utf16String.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }

    public static String bytesToHex(byte[] bytes, String prefix) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(prefix);
            sb.append(String.format("%04x", b & 0xff));
        }
        return sb.toString();
    }
}
