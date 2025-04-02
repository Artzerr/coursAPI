package com.example.projetoptimizer.project.service;


import com.example.projetoptimizer.project.dtos.Project;
import com.example.projetoptimizer.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.*;


@Service
public class ProjectService {

    private final RestClient restClient = RestClient.create();
    private final static String GITHUB_USER_REPO_ENDPOINT = "https://api.github.com/user/repos";

    private final UserService userService;


    @Autowired
    public ProjectService(UserService userService) {
        this.userService = userService;
    }


    public List<Project> getProjects() {
        var token = userService.getCurrentUserToken();

        Project[] githubProjects = restClient
                .get()
                .uri(GITHUB_USER_REPO_ENDPOINT)
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .body(Project[].class);


        if (githubProjects == null) {
            throw new RuntimeException("");
        }

        return Arrays.stream(githubProjects).toList();
    }

    public Project createProject(String name, String description) {
        // TODO: Remplacer l'exception ci dessous par votre code
        throw new UnsupportedOperationException("Fonctionnalité incomplète");
    }


    public void inviteUsersToProject(String projectName, List<String> usernames) {
        // TODO: Remplacer l'exception ci dessous par votre code
        throw new UnsupportedOperationException("Fonctionnalité incomplète");
    }


    public void initiateProject(String projectName, List<String> usersEmail) {
        // TODO: Remplacer l'exception ci dessous par votre code
        throw new UnsupportedOperationException("Fonctionnalité incomplète");
    }


}
