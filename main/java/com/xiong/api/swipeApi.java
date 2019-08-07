package com.xiong.api;

import com.xiong.model.Swipe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回轮播图json
 */
@Controller
public class swipeApi {
    private String[] imgs = {
            "http://localhost:8080/swipe/51cfb782-f94a-4e65-a4a9-8a79782540bc.JPG",
            "http://localhost:8080/swipe/51cfb782-f94a-4e65-a4a9-8a79782540bc.JPG"
            };
    private String[] urls = {
            "",
            ""
            };
    Swipe swipe;
    @GetMapping("/swipe")
    @ResponseBody
//    @CrossOrigin(value = "http://localhost:3000",maxAge = 1800,allowedHeaders = "*")
    public List<Swipe> swipe(){
        List<Swipe> list = new ArrayList<>();
        for (int i=0; i<imgs.length; i++){
            swipe = new Swipe();
            swipe.setImg(imgs[i]);
            swipe.setUrl(urls[i]);
            list.add(swipe);
        }
        return list;
    }

}
