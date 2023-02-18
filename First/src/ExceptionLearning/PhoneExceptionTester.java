package ExceptionLearning;

public class PhoneExceptionTester {

    private static String phoneType;

    public static void main(String[] args) {
        String[] numbers = new String[] { "123-4567", null, "234-4567", "345-5678" };

        for (int i = 0; i < numbers.length; i++) {
            try {
                System.out.println(new Phone("iPhone", numbers[i]));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getLocalizedMessage());
            }

        }
        System.out.println("*********************************************");
        for (int i = 0; i < numbers.length; i++) {
            phoneType = "iPhone";
            System.out.println(new Phone(phoneType, numbers[i]));

        }
    }

}
