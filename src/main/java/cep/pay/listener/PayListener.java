package cep.pay.listener;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayListener implements UpdateListener {
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {

        Double totalAmt= (Double) newEvents[0].get("totalAmt");
        log.info("total amount=", totalAmt);
        System.out.println(totalAmt);
    }

    private static final Logger log = LoggerFactory.getLogger(PayListener.class);



}
