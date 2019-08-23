package org.gerdi.submit.component;

import org.gerdi.submit.model.files.Path;
import org.gerdi.submit.model.submit.FileURL;

import java.util.List;

public abstract class AbstractSubmitComponent<T> {

    public abstract String submitData(final String path, final T metadata, List<FileURL> data);

}
