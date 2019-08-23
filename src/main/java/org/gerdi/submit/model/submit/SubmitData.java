package org.gerdi.submit.model.submit;

import java.util.List;

public class SubmitData<T> {

    private List<FileURL> files;
    private T metadata;

    public List<FileURL> getFiles() {
        return files;
    }

    public void setFiles(final List<FileURL> files) {
        this.files = files;
    }

    public T getMetadata() {
        return metadata;
    }

    public void setMetadata(final T metadata) {
        this.metadata = metadata;
    }


}
