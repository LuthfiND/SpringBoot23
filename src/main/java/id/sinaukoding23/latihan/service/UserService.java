package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.config.JwtTokenUtil;
import id.sinaukoding23.latihan.model.User;
import id.sinaukoding23.latihan.model.dto.LoginDTO;
import id.sinaukoding23.latihan.model.dto.ResponseAuthDTO;
import id.sinaukoding23.latihan.model.dto.UserDTO;
import id.sinaukoding23.latihan.model.mapper.UserMapper;
import id.sinaukoding23.latihan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
        List<User> data = repository.findAllByIsDeleted(false);

        return UserMapper.INSTANCE.toDtoList(data);
    }

    @Transactional(readOnly = true)
    public ResponseAuthDTO doLogin(LoginDTO param){
        User currentUser = repository.findByUsername(param.getUsername());

        ResponseAuthDTO res = UserMapper.INSTANCE.userToResponseAuthDTO(currentUser);

        if (currentUser != null){
            if (currentUser.isActive() && currentUser.getPassword() != null && BCrypt.checkpw(param.getPassword(), currentUser.getPassword())){
                res.setToken(jwtTokenUtil.doGenerateToken(currentUser.getUsername()));

                return res;
            }
        }

        return null;
    }

    @Transactional
    public UserDTO doRegister(UserDTO param){

        User chkUser = repository.findByUsername(param.getUsername());

        if (chkUser == null){
            chkUser = UserMapper.INSTANCE.dtoToEntity(param);
            chkUser.setPassword(BCrypt.hashpw(param.getPassword(), BCrypt.gensalt()));

            chkUser = repository.save(chkUser);

            return UserMapper.INSTANCE.entityToDto(chkUser);
        }

        return null;
    }
}