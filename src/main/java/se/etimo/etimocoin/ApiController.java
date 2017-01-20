package se.etimo.etimocoin;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ozgunayaz on 1/19/17.
 * license: https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    private static ReentrantLock lock = new ReentrantLock();

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    ResultWrapper move(@RequestBody MoveCommandWrapper cmd) {

        ResultWrapper result = new ResultWrapper();
        try {
            lock.lock();
            result.setResult(GameGrid.getGrid().commandMove(cmd));
        } finally {
            lock.unlock();
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    GameGrid boardState() {
        return GameGrid.getGrid();
    }

}
