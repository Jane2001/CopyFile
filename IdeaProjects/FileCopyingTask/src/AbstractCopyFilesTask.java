import java.io.File;
import java.io.IOException;

public abstract class AbstractCopyFilesTask {
    protected abstract void copyFiles(File source, File dest)throws IOException;
}
