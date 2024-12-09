package com.norstarphoenix.neurowavecapstone.services;

package com.norstarphoenix.neurowavecapstone.services;

import com.norstarphoenix.neurowavecapstone.models.Group;
import com.norstarphoenix.neurowavecapstone.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }

    public Group findGroupByName(String name) {
        return groupRepository.findByName(name);
    }

    public void saveGroup(Group group) {
        groupRepository.save(group);
    }
}
