package com.example.DFESW12UserProject.repo;

import com.example.DFESW12UserProject.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {

}
