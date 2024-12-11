package com.norstarphoenix.neurowavecapstone.repositories;

import com.norstarphoenix.neurowavecapstone.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    // Optionally add custom queries, e.g.:
    Group findByName(String name);
}
