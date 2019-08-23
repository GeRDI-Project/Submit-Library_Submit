package org.gerdi.submit.controller;

import org.gerdi.submit.component.AbstractSubmitComponent;
import org.gerdi.submit.model.submit.SubmitData;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 *
 */
@RestController
public class SubmitController<T> {

    @Inject
    private AbstractSubmitComponent<T> controller;

    @PostMapping(value = "/submit")
    public String submit(@RequestParam(value = "path", defaultValue = "/") final String path, @RequestBody final SubmitData<T> body){
        // TODO metadata und data
        return this.controller.submitData(path, body.getMetadata(), body.getFiles());
    }

}
