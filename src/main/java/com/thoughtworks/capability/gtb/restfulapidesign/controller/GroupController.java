package com.thoughtworks.capability.gtb.restfulapidesign.controller;


import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<List> getGroup() {
        return ResponseEntity.status(HttpStatus.OK).body(groupService.splitIntoTeams());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Group> updateTeamName(@PathVariable int id, @RequestParam String groupName) {
        return ResponseEntity.status(HttpStatus.OK).body(groupService.updateGroupName(id, groupName));
    }
}
