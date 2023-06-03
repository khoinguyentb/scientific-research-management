
package com.mycompany.nghiencuukhoahoc.FileUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author vankh
 */
public class FileUtils {
    public void writeObjectToFile(Object serObj, String filePath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Object readObjectFromFile(String filePath) {
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            objectIn.close();
            return obj;
        } catch (IOException ex) {
            return null;
        } catch (ClassNotFoundException ex) {
        	return null;
        }
    }
}
