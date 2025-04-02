package com.example.projetoptimizer.project;

import com.example.projetoptimizer.project.dtos.Project;
import com.example.projetoptimizer.project.dtos.ProjetCreationInput;
import com.example.projetoptimizer.project.service.ProjectService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projets")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping
    public List<Project> getProjects() {
        return projectService.getProjects();
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public Project createProjet(@RequestBody ProjetCreationInput projetCreationInput) {
        return projectService.createProject(projetCreationInput.name(), projetCreationInput.description());
    }

    @PutMapping("add-user/{projectName}")
    public void inviteUsersToProject(@PathVariable("projectName") String projectName, @RequestParam("user") List<String> users) {
        projectService.inviteUsersToProject(projectName, users);
    }


    @PutMapping("initiate/{projectName}")
    public void initiateProject(@PathVariable("projectName") String projectName, @RequestParam("email") List<String> usersEmail) {
        projectService.initiateProject(projectName, usersEmail);
    }


}
