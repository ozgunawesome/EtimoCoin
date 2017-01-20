package se.etimo.etimocoin;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ozgunayaz on 1/19/17.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    private static ReentrantLock lock = new ReentrantLock();

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    ResultWrapper move(@RequestBody MoveCommandWrapper cmd) {
        lock.lock();
        ResultWrapper result = new ResultWrapper(GameGrid.getGrid().commandMove(cmd));
        lock.unlock();
        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    GameGrid boardState() {
        return GameGrid.getGrid();
    }

}
