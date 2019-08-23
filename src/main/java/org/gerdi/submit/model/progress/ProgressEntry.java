package org.gerdi.submit.model.progress;

public class ProgressEntry {

    private String fileName;
    private int percentage;

    public ProgressEntry(final String fileName, final int percentage) {
        this.fileName = fileName;
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(final int percentage) {
        this.percentage = percentage;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

}
