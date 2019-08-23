package org.gerdi.submit.config;


import org.gerdi.submit.model.progress.Progress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends CrudRepository<Progress, String> {
}
