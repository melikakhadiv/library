package ir.mft.library.service;

import ir.mft.library.doa.UserDao;
import ir.mft.library.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public List<User> findAll(){
        return userDao.findAll();
    }

    public User findById(Long id){
        return userDao.findById(id).orElseThrow(() -> new RuntimeException("User Not Found!"));
    }

    public User save(User user){
        return userDao.save(user);
    }

    @Transactional
    public User edit(User user){
        userDao.findById(user.getId()).orElseThrow(() -> new RuntimeException("User:" + user.getId() + "Not Found!"));
        return userDao.save(user);
    }

    public void delete(Long id){
        userDao.deleteById(id);
    }
}
