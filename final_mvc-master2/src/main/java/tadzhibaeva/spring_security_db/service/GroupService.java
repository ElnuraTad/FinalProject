package tadzhibaeva.spring_security_db.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tadzhibaeva.spring_security_db.entity.Group;
import tadzhibaeva.spring_security_db.repo.GroupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

    public void save(Group group) {
        groupRepository.save(group);
    }

    public Group getById(Long id) {
        return groupRepository.findById(id).get();
    }

    public void delete(Long id) {
        groupRepository.deleteById(id);
    }
}
