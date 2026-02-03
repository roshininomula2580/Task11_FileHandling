import java.io.*;
import java.util.Scanner;

public class UserDataStorage {

    private static final String FILE_NAME = "users.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        // Write data to file (APPEND MODE)
        writeUserData(name, email, phone);

        // Read data from file
        readUserData();

        scanner.close();
    }

    private static void writeUserData(String name, String email, String phone) {

        try {
            File file = new File(FILE_NAME);

            // Create file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true); // true = append
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Name: " + name);
            bw.newLine();
            bw.write("Email: " + email);
            bw.newLine();
            bw.write("Phone: " + phone);
            bw.newLine();
            bw.write("------------------------");
            bw.newLine();

            bw.close();
            fw.close();

            System.out.println("\n✅ User data saved successfully!");

        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    private static void readUserData() {

        System.out.println("\n📄 Stored User Records:\n");

        try {
            FileReader fr = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }
}
