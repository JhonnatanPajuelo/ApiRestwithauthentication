package com.jpajuelo.autentificacion.serviceImple;

import com.jpajuelo.autentificacion.model.User;
import com.jpajuelo.autentificacion.repository.IUserRepository;
import com.jpajuelo.autentificacion.service.IUserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    IUserRepository userRepository;

    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }
    /*
    NoSuchElementException: Esta excepción se lanza cuando intentas acceder a un elemento
    que no existe, lo cual es adecuado si no se encuentra un usuario con el ID proporcionado.

    EntityNotFoundException: Si estás utilizando JPA, esta excepción es más específica
    y se utiliza para indicar que una entidad no se encontró.
     */
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No se encontro el Id"));
    }

    @Override
    public Optional<User> findByDni(String dni) {
        if(userRepository.findByDni(dni).isEmpty()){
            throw new EntityNotFoundException("No se encontro el Dni");
        }
        return userRepository.findByDni(dni);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteByDni(String dni) {
        userRepository.deleteByDni(dni);
    }

    @Override
    public User UpdateUser(Long id, User user) {
        if(userRepository.findById(id).isPresent()){
            User userUpdate= userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No se encontro el usuario"));
            userUpdate.setName(user.getName());
            userUpdate.setLastName(user.getLastName());
            userUpdate.setDni(user.getDni());
            userUpdate.setEmail(user.getEmail());
            return userRepository.save(userUpdate);
        }else
            throw new EntityNotFoundException("Error ");

    }
}
