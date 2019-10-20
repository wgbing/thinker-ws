package com.jyou.thinker.ws;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import java.util.Date;

@Slf4j
public class WsClientUntil {

    /**
　　  * webservice客户端调用方法
　　  * @param wsdlURL 服务提供地址
　　  * @param operationName 方法名
　　  * @param params 参数值
　　  * @return: java.lang.String
　　  */
    public static String callWebServiceCxf(String wsdlURL, String operationName, Object... params)  throws Exception {
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactory.createClient(wsdlURL);
        HTTPConduit conduit = (HTTPConduit)client.getConduit();
        HTTPClientPolicy policy = new HTTPClientPolicy();
        policy.setConnectionTimeout(100000);//设置超时时间
        policy.setReceiveTimeout(100000);//设置超时时间
        conduit.setClient(policy);
        Object[] objects = client.invoke(operationName, params);
        return JSONUtil.toJsonStr(objects[0]);
    }

    //动态调用 反射机制
    public static void main(String[] args) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",5L);
        jsonObject.put("userName","sads"+ IdUtil.fastSimpleUUID());
        jsonObject.put("password","123456");
        jsonObject.put("createTime",new Date());

        log.error("==================update=================",
                WsClientUntil.callWebServiceCxf("http://localhost:8080/ws/user?wsdl","update",jsonObject.toString()));

    }

}
