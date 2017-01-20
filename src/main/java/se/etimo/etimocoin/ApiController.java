package se.etimo.etimocoin;

import org.springframework.web.bind.annotation.*;

/**
 * Created by ozgunayaz on 1/19/17.
 * license: https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

@RestController
@RequestMapping("/api")
public class ApiController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    synchronized ResultWrapper move(@RequestBody MoveCommandWrapper cmd) {

        return new ResultWrapper(GameGrid.getGrid().commandMove(cmd));

    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    synchronized GameGrid boardState() {

        return GameGrid.getGrid();

    }

}
