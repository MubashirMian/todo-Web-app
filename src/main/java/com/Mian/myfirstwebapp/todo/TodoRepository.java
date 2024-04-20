package com.Mian.myfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// bean managed by this repository is todo and the id primary key is of integer type
public interface TodoRepository extends JpaRepository<Todo,Integer> {
	

	public List<Todo> findByUsername(String username);
}
