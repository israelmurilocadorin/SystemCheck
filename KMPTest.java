public class KMPTest {

    public static void main(String args[]) {

        String pat = String.valueOf(args[0]);

        KMP kmp = new KMP(pat);

        kmp.retornar();
    }
}