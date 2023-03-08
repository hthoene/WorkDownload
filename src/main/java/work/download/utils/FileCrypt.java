package work.download.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class FileCrypt {

    public static void encryptFile(Path path, int key) throws IOException {
        System.out.println("Encryption file: " + path.toString());

        // Selecting a Image for operation
        FileInputStream fis = new FileInputStream(
                path.toString());

        // Converting Image into byte array, create a
        // array of same size as Image size

        byte data[] = new byte[fis.available()];

        // Read the array
        fis.read(data);
        int i = 0;

        // Performing an XOR operation on each value of
        // byte array due to which every value of Image
        // will change.
        for (byte b : data) {
            data[i] = (byte)(b ^ key);
            i++;
        }

        // Opening a file for writing purpose
        FileOutputStream fos = new FileOutputStream(
                path.toString());

        // Writing new byte array value to image which
        // will Encrypt it.

        fos.write(data);

        // Closing file
        fos.close();
        fis.close();
        System.out.println("Encryption Done...");

    }

    public static void decryptFile(Path path, int key) throws IOException {
        FileInputStream fis = new FileInputStream(
                path.toString());

        // Converting image into byte array,it will
        // Create a array of same size as image.
        byte data[] = new byte[fis.available()];

        // Read the array

        fis.read(data);
        int i = 0;

        // Performing an XOR operation
        // on each value of
        // byte array to Decrypt it.
        for (byte b : data) {
            data[i] = (byte)(b ^ key);
            i++;
        }

        // Opening file for writing purpose
        FileOutputStream fos = new FileOutputStream(
                path.toString());

        // Writing Decrypted data on Image
        fos.write(data);
        fos.close();
        fis.close();
        System.out.println("Decryption Done...");
    }




}
