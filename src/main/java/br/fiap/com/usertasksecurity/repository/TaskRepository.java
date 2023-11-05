package br.fiap.com.usertasksecurity.repository;

import br.fiap.com.usertasksecurity.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}