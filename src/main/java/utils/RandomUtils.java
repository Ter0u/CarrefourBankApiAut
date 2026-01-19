package utils;

public final class RandomUtils {

    private RandomUtils() {}


    private static String randomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt((int) (Math.random() * chars.length())));
        }

        return sb.toString();
    }

    public static String randomEmail() {
        String random = randomString(8);
        return "testAut" + random + "@qa.com.br";
    }

    public static String randomNome() {
        String random = randomString(9);
        return "testAut" + random + " Da Silva";
    }

}
