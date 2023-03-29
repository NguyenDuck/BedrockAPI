package nguyenduck.file;

import java.io.File;

public class FileContent {
    private String content;
    private final String fileExt;
    private final String fileName;
    File path;

    FileContent(String fileName, String fileExtension) {
        this.fileName = fileName;
        fileExt = fileExtension;
    }

    public String getFileName() {
        return fileName + "." + fileExt;
    }

    public String getContent() {
        return content;
    }

    protected void setContent(String content) {
        this.content = content;
    }
}
