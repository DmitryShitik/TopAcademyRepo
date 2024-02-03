import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        String fileName = "test.txt";
        String fullName = "";
        String dirName = System.getProperty("user.dir");
        fullName = dirName + File.separator + fileName;
        System.out.println("File path : " + fullName);
        File file = new File(fullName);

        if (!file.exists()) {
            try {
                if (file.createNewFile())
                    System.out.println("Don");
                else
                    System.out.println("Non");
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        } else
            System.out.println("File already");
        File dir = new File((dirName + "/tmp/user/java/bin"));
        dir.mkdirs();

        byte[] b = null;
        int lenB = 0;
        try {
            InputStream input = new FileInputStream(file);
            b = new byte[input.available()];
            lenB = input.read(b);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        System.out.println(lenB==0?"qwe":(char) b[0]);
    }
}
