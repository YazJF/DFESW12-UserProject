package com.example.DFESW12UserProject.repo;

import com.example.DFESW12UserProject.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepo extends JpaRepository<Users, Long> {

    List<Users> findByAge(Long age);

    List<Users> findByMailingList(Boolean mailingList);

}
