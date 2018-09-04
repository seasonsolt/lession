package cep.pay.service;

import cep.pay.event.PayEvent;
import cep.pay.listener.PayListener;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayService {
    EPServiceProvider engine;
    private static final Logger log = LoggerFactory.getLogger(PayService.class);

    public PayService(EPServiceProvider engine){
       this.engine = engine;
    }

    public void doMonitor(){
        engine.getEPAdministrator().getConfiguration().addEventType(PayEvent.class);
        String epl = "select sum(payAmount) as totalAmt from PayEvent#length(2)";
        EPStatement statement = engine.getEPAdministrator().createEPL(epl);
        EPRuntime cepRT = engine.getEPRuntime();

        PayListener listener = new PayListener();

        statement.addListener(listener);

        PayEvent payRequest = new PayEvent();
        payRequest.setPayAmount(new Double("100"));
        payRequest.setIp("192.168.1.1");

        PayEvent payRequest1 = new PayEvent();
        payRequest1.setPayAmount(new Double("200"));
        payRequest1.setIp("192.168.1.1");

        PayEvent payRequest2 = new PayEvent();
        payRequest2.setPayAmount(new Double("300"));
        payRequest2.setIp("192.168.1.1");

        PayEvent payRequest3 = new PayEvent();
        payRequest3.setPayAmount(new Double("300"));
        payRequest3.setIp("192.168.1.1");

        cepRT.sendEvent(payRequest);
        cepRT.sendEvent(payRequest1);
        cepRT.sendEvent(payRequest2);
        cepRT.sendEvent(payRequest3);

    }

}
