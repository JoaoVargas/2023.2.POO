package apresentacao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Testes {
    public static void main(String[] args) throws NoSuchAlgorithmException {
//        MessageDigest digest = MessageDigest.getInstance("SHA-256");
//
//        String senha = "abc";
//        byte[] enc = digest.digest(senha.getBytes(StandardCharsets.UTF_8));
//
//        String senha2 = "abC";
//        byte[] enc2 = digest.digest(senha2.getBytes(StandardCharsets.UTF_8));
//
//        if (Arrays.equals(enc, enc2)) {
//            System.out.println("okay");
//        } else {
//            System.out.println("nah");
//        }
//
//        System.out.println(Arrays.toString(enc));
//        System.out.println(Arrays.toString(enc2));
//
//        int a = 5;
//
//        String b = String.valueOf(a).substring(String.valueOf(a).length() - 1);
//
//        System.out.println(b);

        String a = "{'";

        for (int i = 97; i < 123; i++) {
            a += (char) i;
            a += "', '";
        }

        a += "}";

        System.out.println(a);

    }
}
