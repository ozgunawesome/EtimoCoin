package se.etimo.etimocoin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ozgunayaz on 1/19/17.
 * license: https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

@Controller
public class BoardController {

    @GetMapping("/")
    public String home() {
        return "boardview";
    }

}
