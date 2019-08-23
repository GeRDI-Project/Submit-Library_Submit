package org.gerdi.submit.model.files;

public class File implements IPathElement {

    private String fileName;

    public File(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getType() {
        return "File";
    }

    @Override
    public String getDisplayName() {
        return this.fileName;
    }
}
