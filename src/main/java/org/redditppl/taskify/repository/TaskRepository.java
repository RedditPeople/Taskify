package org.redditppl.taskify.repository;

import org.redditppl.taskify.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
