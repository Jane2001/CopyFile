import java.io.*;

public class CopyFilesDirectlyTask extends AbstractCopyFilesTask {
    @Override
    protected void copyFiles(File source, File dest) throws IOException {
        try(final InputStream sourceStream = new FileInputStream(source);
            final OutputStream destStream = new FileOutputStream(dest)){
            final long totalSize = source.length();
            long readCount = 0;
            while(sourceStream.available()>0){
                int readByte = sourceStream.read();
                destStream.write(readByte);
                readCount++;
                System.out.println("Progress: " + readCount + "/" + totalSize);
            }
        }

    }
}

