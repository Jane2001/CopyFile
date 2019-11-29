import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Wrong number of arguments");
            System.out.println("Usage: app.jar.file dest.file");
        }
        final File sourceFile = new File(args[0]);
        if(!sourceFile.exists() || !sourceFile.isFile()){
            System.out.println("Source does not exist or is not file: " + sourceFile);
        }
        final File destFile = new File(args[1]);
        if(!destFile.exists() || !destFile.isFile()){
            System.out.println("Destination does not exist or is not file: " + destFile);
        }
        CopyFilesByteArrayTask copy = new CopyFilesByteArrayTask();
        try {
            copy.copyFiles(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
