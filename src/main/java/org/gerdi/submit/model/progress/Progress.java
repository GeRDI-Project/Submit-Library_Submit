package org.gerdi.submit.model.progress;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Arrays;
import java.util.List;

@RedisHash(value = "Progress", timeToLive = 1800)
public class Progress {

    @Id private String id;
    private String user;
    private List<ProgressEntry> elements;

    public Progress(final String id, final ProgressEntry... entries) {
        this.id = id;
        this.elements = Arrays.asList(entries);
    }

    public Progress(final String id, final List<ProgressEntry> entries) {
        this.id = id;
        this.elements = entries;
    }

    public Progress() {}

    public String getId() {
        return this.id;
    }

    public List<ProgressEntry> getElements() {
        return this.elements;
    }

    public String getUser() {
        return user;
    }

    public void setUser(final String user) {
        this.user = user;
    }
}
