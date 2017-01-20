package se.etimo.etimocoin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * Created by ozgunayaz on 1/19/17.
 */
@Controller
public class BoardController {

    @GetMapping("/")
    public String home() {
        return "boardview";
    }

}
