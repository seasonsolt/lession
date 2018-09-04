package cep.pay.service;

import cep.pay.event.PayResEvent;
import cep.pay.listener.ResponseListener;
import com.espertech.esper.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseService {
    EPServiceProvider engine;
    private static final Logger log = LoggerFactory.getLogger(ResponseService.class);

    public ResponseService(EPServiceProvider engine){
       this.engine = engine;
    }

    public void doMonitor(){
        engine.getEPAdministrator().getConfiguration().addEventType(PayResEvent.class);
        String epl = "select count(1) as errCnt from PayResEvent#length(3) where resCode='20001'";
        EPStatement statement = engine.getEPAdministrator().createEPL(epl);
        EPRuntime cepRT = engine.getEPRuntime();


        ResponseListener listener = new ResponseListener();
        statement.addListener(listener);
        PayResEvent payResponse= new PayResEvent();
        payResponse.setResCode("20001");

        cepRT.sendEvent(payResponse);
        cepRT.sendEvent(payResponse);
        cepRT.sendEvent(payResponse);

    }

}
