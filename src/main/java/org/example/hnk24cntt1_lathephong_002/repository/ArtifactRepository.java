package org.example.hnk24cntt1_lathephong_002.repository;

import org.example.hnk24cntt1_lathephong_002.model.Artifact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
    Page<Artifact> findByNameContainingIgnoreCase(String key, Pageable pageable);
}
