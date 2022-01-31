package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("user")
//@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
//    @Value("${pattern.dateformat}")
//    private String date;
    @Autowired
    private PatternProperties properties;
    @GetMapping("now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }
    @GetMapping("pro")
    private PatternProperties now2(){
       return   properties;
    }
    @GetMapping("/{id}")
//    public User queryById(@PathVariable("id") Long id,@RequestHeader("Truth") String truth) {
//        System.out.println("Truth:"+truth);
//        return userService.queryById(id);
//    }
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
