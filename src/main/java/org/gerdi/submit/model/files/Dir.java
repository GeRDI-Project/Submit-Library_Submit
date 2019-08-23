package org.gerdi.submit.model.files;

public class Dir implements IPathElement {

    private String dirName;

    public Dir(final String dirName) {
        this.dirName = dirName;
    }

    @Override
    public String getType() {
        return "Directory";
    }

    @Override
    public String getDisplayName() {
        return this.dirName;
    }
}
