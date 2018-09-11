package cep.pay.listener;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseListener implements UpdateListener {
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        Long errCnt = (Long)newEvents[0].get("errCnt");
//        System.out.println("errCnt=" + errCnt);
        log.debug("errCnt=", errCnt);
        if(errCnt >= 3){
            System.out.println("res=20001, errCnt= " + errCnt + " 超过三次，加入黑名单");
            log.info("res=20001  超过三次，加入黑名单");
        }
    }

    private static final Logger log = LoggerFactory.getLogger(ResponseListener.class);

}
