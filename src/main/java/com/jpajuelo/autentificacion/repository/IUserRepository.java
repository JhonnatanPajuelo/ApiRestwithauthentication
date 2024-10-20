package com.jpajuelo.autentificacion.repository;

import com.jpajuelo.autentificacion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
    Usar una interfaz que extiende de JpaRepository es una de las mejores prácticas en Spring Data JPA,
     ya que proporciona una abstracción más limpia y flexible para interactuar con la base de datos.
 */

/*
 ***No llevan Modificadores de Acceso
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByDni(String dni);

    void deleteByDni(String dni);

}
