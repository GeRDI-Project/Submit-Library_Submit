package org.gerdi.submit.controller;

import org.gerdi.submit.config.ProgressRepository;
import org.gerdi.submit.model.progress.Progress;
import org.gerdi.submit.model.progress.ProgressEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

/**
 *
 */
@RestController
public class ProgressController {

    @Autowired
    private ProgressRepository repo;

    @GetMapping(value = "/progress/{id}")
    public Progress getPath(@PathVariable("id") final String id){
        //throw new UnsupportedOperationException();
        final Optional<Progress> elem = repo.findById(id);
        if (!elem.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Session does not exist");
        }
        final Progress val = elem.get();
        return val;
    }

    @RequestMapping(value = "/progress", method = RequestMethod.GET)
    public String getPath(){
        final UUID uuid = UUID.randomUUID();
        Progress progress = new Progress(uuid.toString(), new ProgressEntry("hello", 20));
        final Progress val = repo.save(progress);
        return uuid.toString();
    }

}