package com.jusun.first.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired UserRepository userRepository;

    @GetMapping("/selectAll")
    public List<User> selectAll(){
        return userRepository.findAll();
    }

    @PostMapping("/singup")
    public boolean singup(@RequestBody User user){

        if(idcheck(user.getUserid())){
            return true;
        }else{
            userRepository.saveAndFlush(user);
            System.out.println(user);
            return false;
        }


    }

    @PostMapping("/singin")
    public String singin(@RequestBody User loginUser){
        String result = "";

        User u = userRepository.findByUserid(loginUser.getUserid());

        if(u == null){
            result = "로그인 실패";
        }else if(u.getUserid().equals(loginUser.getUserid())){
            if (u.getPasswd().equals(loginUser.getPasswd())){
                result = "로그인 성공";
            }else {
                result = "비밀번호를 확인해주세요";
            }
        }
        return result;
    }

    @GetMapping("/{userid}")
    public boolean idcheck(@PathVariable String userid){
        return (userRepository.findByUserid(userid) != null)? true:false;
    }
}
