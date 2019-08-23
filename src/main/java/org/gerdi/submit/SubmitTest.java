package org.gerdi.submit;

import org.gerdi.submit.component.AbstractSubmitComponent;
import org.gerdi.submit.model.submit.FileURL;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubmitTest extends AbstractSubmitComponent<String> {
    @Override
    public String submitData(final String path, final String metadata, final List<FileURL> data) {
        return "YOLO";
    }

}
