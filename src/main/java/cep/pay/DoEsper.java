package cep.pay;

import cep.pay.service.PayService;
import cep.pay.service.ResponseService;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;

public class DoEsper {

    public static void main(String[] args) {
        EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();

        PayService payService = new PayService(engine);
        payService.doMonitor();

        ResponseService responseService = new ResponseService(engine);
        responseService.doMonitor();
    }
}
