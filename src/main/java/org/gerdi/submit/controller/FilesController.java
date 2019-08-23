package org.gerdi.submit.controller;

import org.gerdi.submit.component.AbstractFilesComponent;
import org.gerdi.submit.model.files.Path;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 *
 */
@RestController
public class FilesController {

    @Inject
    private AbstractFilesComponent controller;

    @RequestMapping(value = "/files", method = RequestMethod.GET)
    public Path getPath(@RequestParam(value = "path", defaultValue = "/") final String path){
        return this.controller.getPath(path);
    }

}
