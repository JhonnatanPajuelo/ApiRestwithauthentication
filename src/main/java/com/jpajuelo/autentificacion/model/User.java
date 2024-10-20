package com.jpajuelo.autentificacion.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

/*
TABLE (OPCIONAL), define el nombre de la tabla en la base de datos.
        Si no especificas un nombre, Spring Boot usará el nombre de la clase
        por defecto.
        */
@Getter @Setter  //Getter y Setter
@AllArgsConstructor //Constructor
@NoArgsConstructor //Constructor sin parametros
@Entity //Declara la clase como una tabla en BD
public class User {
    /*
    nullable -> true por defecto,
    para que no acepte valores nulos -> False

    unique -> False por defecto,
    para que el valor sea unico en la tabla ->True

     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @Column(unique=true, nullable=false,length=8)
    private String dni;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    //CreationTimestamp --> Hibernate se encargue de establecer el valor automáticamente.
    //Updatable -->No debe ser actualizable después de su creación. Esto es útil si quieres evitar que se modifique accidentalmente.
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate FechaCreacion;

}
