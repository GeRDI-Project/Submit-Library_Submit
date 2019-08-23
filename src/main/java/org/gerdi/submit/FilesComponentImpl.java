package org.gerdi.submit;

import org.gerdi.submit.component.AbstractFilesComponent;
import org.gerdi.submit.model.files.File;
import org.gerdi.submit.model.files.IPathElement;
import org.gerdi.submit.model.files.Path;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class FilesComponentImpl extends AbstractFilesComponent {
    @Override
    public Path getPath(final String path) {

        IPathElement elem = new File(path);
        Path hello = new Path(Arrays.asList(elem));
        return hello;
    }
}
