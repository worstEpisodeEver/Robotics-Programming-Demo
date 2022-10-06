import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numberOfSets = 10;
        int[] array = new int[numberOfSets];
        Scanner myInput = new Scanner(System.in);

        for (int i = 0; i < numberOfSets; i++) {
            Map<String, String> emailSet = new HashMap<>();
            String numberInput = myInput.nextLine();

            if (numberInput.equals("")){
                continue;
            }

            int numberinput = Integer.parseInt(numberInput);
            for (int j = 0; j < numberinput; j++) {
                String email = myInput.nextLine();
                if (email.equals("")){
                    continue;
                }
                String emailResult = putEmailMap(email);
                emailSet.put(emailResult, "");
            }
            array[i] = emailSet.size();
        }
        for (int i = 0; i < numberOfSets; i++) {
            System.out.println(array[i]);
        }
    }

    private static String putEmailMap(String email) {
        String currentEmail;
        currentEmail = email.toLowerCase();

        int posAtSign = currentEmail.indexOf("@");
        String beforeAtSign = currentEmail.substring( 0, posAtSign );
        String afterAtSign = currentEmail.substring( posAtSign);

        beforeAtSign = beforeAtSign.replace(".", "");

        int posPlus = beforeAtSign.indexOf("+");
        beforeAtSign = posPlus <0? beforeAtSign: beforeAtSign.substring(0, posPlus);
        return beforeAtSign + afterAtSign ;
    }
}