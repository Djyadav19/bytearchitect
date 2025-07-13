package com.bytearchitect;
import org.springframework.web.bind.annotation.*;
/**
 * we will use RestController annotation
 * RestController annotation is used to create web controllers that return data.
 * typically json.// what about other data type like xml plain text?
 * It combines @Controller
 * @ResponseBody.
 * or insted of this we can annotate the class as controller and the method with The @ResponseBody.
 *
 */
@RestController
@RequestMapping("/ping")
public class PingController{
    @GetMapping("")
    public String ping(){
        return "Pong";
    }
}