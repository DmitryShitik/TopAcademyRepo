import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(new File("D:\\lessons\\testWork\\tmp\\user\\java\\bin\\test.txt"));
            File file = new File("outputFile3.txt");
            out = new FileOutputStream(file);
            int c;
            while ((c = in.read()) != -1) {
                if (c < 65) out.write(c);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
    }
}