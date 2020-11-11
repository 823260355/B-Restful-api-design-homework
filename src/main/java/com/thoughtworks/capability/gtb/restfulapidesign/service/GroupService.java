package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    StudentService studentService;

    final int groupNum = 6;
    private List<Group> groups = new ArrayList();


    public GroupService() {
        for (int i = 0; i < groupNum; i++) {
            groups.add(Group.builder().id(i + 1).name("Team " + (i + 1)).note("").groupMembers(null).build());
        }
    }

    public List<Group> splitIntoTeams() {
        List<Student> students = studentService.getStudentsByGender(null);
        Collections.shuffle(students);

        for (Group group : groups) {
            List<Student> members = new ArrayList();
            for (int i = 0; i < students.size(); i++) {
                int remainder = (i + 1) % groupNum;
                if (remainder == group.getId()) {
                    members.add(students.get(i));
                }
                if (group.getId() == groupNum) {
                    if (remainder == 0) {
                        members.add(students.get(i));
                    }
                }
                group.setGroupMembers(members);
            }
        }
        return groups;
    }
}
