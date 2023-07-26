package com.javashun.cloud.module.system;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javashun.cloud.framework.common.util.MapSortUtils;
import com.javashun.cloud.framework.common.util.Md5Utils;
import com.javashun.cloud.framework.common.util.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/api/payTest1111")
public class TestNewPayController1 {

    @RequestMapping(value = "/notify")
    @ResponseBody
    public String notify(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
        String siteCode = request.getHeader("Request-Site-Code");

        //根据siteCode查看 aes key
        //String result = AesUtil.AESDncode("7d676c53a769ba4118718a3a6a0a31bf", json);
        JSONObject resJson = JSONObject.parseObject(json);
        String sign = resJson.getString("sign");
        String dataJson = resJson.getString("data");
        //String siteCode = resJson.getString("siteCode");
        JSONObject resultData = JSONObject.parseObject(dataJson);

        return "{\"code\":\"0000\",\"msg\":\"success\"}";
    }

    @RequestMapping(value = "/new/pay")
    public void pay() {
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("userId", "4312432");
            data.put("extra", "王长打");
            data.put("amount", "300");
            data.put("currency","CNY");
            //data.put("catalogCode","wechatH5");
            data.put("clientIp","");
            data.put("orderNo",randomStr(10));//随机生成
            //data.put("channelId", 291543273440731136L);//填对应通道Id
            data.put("notifyUrl", "http://frp.javashun.com:8888/ims/api/payTest/notify");//对应回调接口地址
            log.info("数据data："+JSON.toJSONString(data));
            // 58qp   4917f0a26f4a7261af4017fc43e4af4c
            // AY  2f68f69f194bc082fedbbe323dab54a3
            // bet365 d56bcc27d5eb55e6b941816e852832d9
             // qingting 25faa76e140e48a4e6063eb4a22c9d7a
            // 84qp 3325ddc137798fc8274f30695b33b1db
            // bf3365 3f87895d6f0b29d1683ba9f4f5bdb423
            //17qp  da662d8ce2a4754fe07d4347870640dd
            // tthlw001  0cda687f301e93ed1ff174ad80b91354
            // renhe a4c3c312d94cdb472631e1a429ba74ad
            // bet365 d56bcc27d5eb55e6b941816e852832d9
            // yizhifu 21044e19ec69df3e8a45660efdcc7a8a
            // yxzf 6b7083e1950804c10c23e66f070deb59
            // mayi f51f66b2ca35fef6c658c9871c1e6a59
            // fusheng 528de193e1436a911d2ce44db103934b
            // tangguo a0db7586939b334ef3d3354f6c711b10
            String text = MapSortUtils.getMapByKeyDesc2(data) + "&key=8b09090542c64681e925b6e590543d7f";
            log.info("签名串str："+text);
            String sign = Md5Utils.hash(text).toUpperCase();
            Map<String, Object> apiRequest = new HashMap<>();
            apiRequest.put("data", data);
            //apiRequest.put("siteCode", "Yuletong");
            apiRequest.put("sign", sign);

            String jsonData = JSON.toJSONString(apiRequest);
            log.info("最终数据jsonDataStr:"+jsonData);


            //String params = AesUtil.AESEncode("7d676c53a769ba4118718a3a6a0a31bf",JSON.toJSONString(apiRequest));
            //log.info("最终加密后params:"+params);
            //String res = HttpUtil.doPost("http://localhost:8081/api/payment", headers,params);
            //String res = HttpUtil.doPost("http://pay-api.66666ew.com/api/payment", headers,params);

            Map<String, String> headers = new HashMap<>();
            headers.put("Request-Site-Code", "xqp01");//商户识别码 code
            headers.put("Request-Id", UUID.randomUUID().toString());//requestId
            //headers.put("Request-Platform-Id", "291537707163115520");//支付平台Id,对应平台Id
            headers.put("Request-Channel-Id", "999");//支付平台Id,对应平台Id
            log.info("请求头header:"+headers);
            //String res = HttpUtil.doPost("http://18.162.151.170:8081/api/payment/yuletong", headers,jsonData);
            //String res = HttpUtil.doPost("http://api.1thpay.com:8081/api/payment/randomChannel", headers,jsonData);
            String res = HttpUtil.doPost("http://api.1thpay.com:8081/api/payment", headers,jsonData);
            //String res = HttpUtil.doPost("http://16.163.41.228:8081/api/payment", headers,jsonData);
            //String res = HttpUtil.doPost("http://127.0.0.1:8081/api/payment/randomChannel", headers,jsonData);
            //String res = HttpUtil.doPost("http://127.0.0.1:8081/api/payment", headers,jsonData);
            JSONObject resJson = JSON.parseObject(res);
            log.info(JSON.toJSONString(resJson));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String randomStr(int num) {
        char[] randomMetaData = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9' };
        Random random = new Random();
        String tNonceStr = "";
        for (int i = 0; i < num; i++) {
            tNonceStr += (randomMetaData[random.nextInt(randomMetaData.length - 1)]);
        }
        return tNonceStr;
    }
    public static void main(String[] args) {
        new TestNewPayController1().pay();
//        String url = "https://payme.vn/g/payment/7D1IBWUPE2FQ";
//        String s = HttpUtil.doGet("http://43.198.151.166/?uri=" + url);
//        System.out.println(s);
    }
}
