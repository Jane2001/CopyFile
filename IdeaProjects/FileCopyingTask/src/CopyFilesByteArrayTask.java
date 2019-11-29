import java.io.*;

public class CopyFilesByteArrayTask extends AbstractCopyFilesTask {

    @Override
    protected void copyFiles(File source, File dest) throws IOException {
        try(final InputStream sourceStream = new FileInputStream(source);
            final OutputStream destStream = new FileOutputStream(dest)){
            final long totalSize = source.length();
            long totalReadCount = 0;
            final byte[] buffer = new byte[4096];
            while(sourceStream.available()>0){
                int readCount = sourceStream.read(buffer);
                destStream.write(buffer, 0, readCount);
                totalReadCount += readCount;
                System.out.println("Progress: " + totalReadCount + "/" + totalSize);
            }
        }

    }
}
