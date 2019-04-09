package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 10:45 2019-02-25
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public enum ThreadPoolEnum {
    SINGLE(Executors.newSingleThreadExecutor()),
    FIXED(Executors.newFixedThreadPool(20));

    ExecutorService service;

    ThreadPoolEnum(ExecutorService service ){
        this.service = service;
    }

    public ExecutorService getPoolInstance(){
        return service;
    }

}
