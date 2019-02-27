package com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class TestController {

    @PostMapping("test")
    public String test(@RequestParam String id){
        log.info("========================={}",id);

        return "success";
    }


    public static void main(String[] args) {
        List<String> list1 =new ArrayList<>();
        for (int i = 0 ; i <10000;i++){
            list1.add("test1_"+i);
        }

  /*      List<String> list2 =new ArrayList<>();
        for (int i = 0 ; i <10000;i++){
            list2.add("test2_"+i);
        }*/
        long l1 = System.nanoTime();
        for (int i = 0 ; i<list1.size();i++){
            try{
                Thread.sleep(10);
            }catch(Exception e){

            }
        }

//        list1.forEach(s->{
//            try{
//                Thread.sleep(10);
//            }catch(Exception e){
//
//            }
//        } );
        long l2 = System.nanoTime() - l1;
        System.out.println(l2);

    }
}
