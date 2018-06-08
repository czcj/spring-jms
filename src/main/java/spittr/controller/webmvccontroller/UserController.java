package spittr.controller.webmvccontroller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import spittr.pojo.Spitter;

import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Controller
public class UserController {

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestPart("profilePicture") byte[] profilePicture, @Valid Spitter spittle, Errors errors){
        try {
            Date date = new Date();
            File file = new File("D:\\nodeDemo\\springweb-config\\src\\main\\resources\\jpg\\"+date.getTime()+".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(profilePicture);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
