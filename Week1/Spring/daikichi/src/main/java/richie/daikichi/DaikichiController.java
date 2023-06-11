package richie.daikichi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")

public class DaikichiController {
    @RequestMapping("/")
    public String index() {
        return "Welcome";
    }


    @RequestMapping("/{var1}/{var2}")
    public String travelorlotto(
        @PathVariable("var1")String var1,
        @PathVariable("var2")String var2
        ) {
            System.out.println(var1);
            System.out.println(var2);

            if(var1.equals("travel")) {
                return String.format("Congratulations! You will soon travel to %s\n", var2);
            }
            if(var1.equals("lotto")) {
                int var = Integer.parseInt(var2);
                if(var % 2 == 0) {
                    return "You will take a grand journey in the near future, but be weary of tempting offers";
                }
                else {
                    return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
                }
            }
            return "Huh?";
        }

    // way2
    @RequestMapping("/{pathvar}")
    public String today(@PathVariable("pathvar")String pathvar) {
        if(pathvar.equals("today")) {
            return "Today you will find luck in all of your endeavors!";
        } 
        if(pathvar.equals("tomorrow")) {
            return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
        } 
        else {
            return "Whaaat?";
        }
    }

    //way 1
    // @RequestMapping("/today")
    // public String today() {
    //     return "Today you will find luck in all of your endeavors!";
    // }

    // @RequestMapping("/tomorrow")
    // public String tomorrow() {
    //     return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    // }
}
