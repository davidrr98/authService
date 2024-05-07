package com.davivienda.AuthService.Repository;

import com.davivienda.AuthService.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, String> {

}
