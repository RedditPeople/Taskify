package org.redditppl.taskify;

import lombok.AllArgsConstructor;
import org.redditppl.taskify.model.Task;
import org.redditppl.taskify.model.User;
import org.redditppl.taskify.service.TaskService;
import org.redditppl.taskify.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@AllArgsConstructor
@SpringBootApplication
public class TaskifyApplication {

    private final UserService userService;
    private final TaskService taskService;

    public static void main(String[] args) {
        SpringApplication.run(TaskifyApplication.class, args);
    }


    @Bean
    InitializingBean sendDatabase() {
        return () -> {
			User testUser1 = new User("test_user1");
			userService.saveUser(testUser1);
			User testUser2 = new User("test_user2");
			userService.saveUser(testUser2);

			Task testTask1 = new Task("test_task1");
			taskService.saveTask(testTask1);
			Task testTask2 = new Task("test_task2");
			taskService.saveTask(testTask2);
        };
    }

}
