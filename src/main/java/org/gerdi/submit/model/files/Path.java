package org.gerdi.submit.model.files;

import java.util.List;

public class Path {

    private List<IPathElement> elements;

    public Path(List<IPathElement> elements) {
        this.elements = elements;
    }

    public List<IPathElement> getElements() {
        return this.elements;
    }

}
