package com.librarymanagement.librarymanagement.Users;


import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UsersDTO, Integer>{
   UsersDTO  findByUser_name(String user_name);
    
}
