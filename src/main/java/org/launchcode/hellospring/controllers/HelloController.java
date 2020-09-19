package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring";
//}

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring";
    }

//    //Handles request of the form /hello?name=LaunchCode
//   @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    public String helloWithQueryParam(@RequestParam String name){
//      return "Hello, "+ name + "!";
//    }

//    //Handles requests of the form /hello/LaunchCode
//    @GetMapping("hello/{name}")
//    public String helloWithPathParameter(@PathVariable String name){
//    return "Hello, " + name + "!";
//    }



    //Display the form
    @RequestMapping(value = "hello", method = RequestMethod.GET )
    public String helloForm(){
        String form = "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<select id='language' name='language'>" +
                    "<option value='English'>English</option>" +
                    "<option value='French'>French </option>" +
                    "<option value='Spanish'>Spanish </option>" +
                    "<option value='German'>German</option>'>" +
                    "<option value='Icelandic'>Icelandic</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
        return form;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    public String sayHello(@RequestParam String name, @RequestParam String language){
        return createMessage(name, language);
    }

    public static String createMessage(@RequestParam String name, @RequestParam String language){
        String message = "";
        if(language.equals("English")){
            message = "Hello," + name + "!";
        }else if(language.equals("French")){
            message = "Bonjour," + name + "!";
        }
        return message;
    }

}
