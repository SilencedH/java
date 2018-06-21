package net.youzule.youzule.config;

import com.alibaba.fastjson.JSON;
import net.youzule.youzule.common.constant.QueueConstant;
import net.youzule.youzule.common.other.MessageEntity;
import net.youzule.youzule.module.blog.mq.producer.Producer;
import net.youzule.youzule.utils.http.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @title:interceptor
 * @description:拦截器
 * @company:
 * @author:zhaodahai
 * @date:2018/5/10 15:37
 **/

@Component
public class MyInterceptor implements HandlerInterceptor {

    public static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Autowired
    private Producer producer;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try{
            handleRequest(request);
        }catch (Exception e){
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
            handleResponse(request);
    }

    //处理请求信息
    public void handleRequest(HttpServletRequest request){

        //封装一些属性，供response时使用
        long start = System.currentTimeMillis();
        String id = UUID.randomUUID().toString();
        String servletPath = request.getServletPath();
        String ip = IPUtil.getIpAddress(request);
        request.setAttribute("start",start);
        request.setAttribute("id",id);
        request.setAttribute("ip",ip);
        logger.info("请求id:[" + id + "],请求path:[" + servletPath+"]开始,ip:" + ip);
    }

    //处理返回的请求信息
    public void handleResponse(HttpServletRequest request){
        //获取request中的attribute信息
        String ip = String.valueOf(request.getAttribute("ip"));
        long start = (long) request.getAttribute("start");
        String id = String.valueOf(request.getAttribute("id"));
        String servletPath = request.getServletPath();
        String queue = QueueConstant.REQUEST;
        //当前时间戳
        long end = System.currentTimeMillis();
        try {
            /*发送给mq*/
            Map<String,String> map = new HashMap<>();
            map.put("ip",ip);
            map.put("id",id);
            map.put("servletPath",servletPath);
            map.put("start",String.valueOf(start));
            map.put("end",String.valueOf(end));
            //封装消息体
            MessageEntity<Map<String,String>> messageEntity = new MessageEntity<>(map);
            logger.info("调用方法发送mq-" + queue + ":{}",JSON.toJSONString(messageEntity));
            producer.sendMessage(queue,messageEntity);
        }catch (Exception e){
            logger.info("发送mq-" + queue + ":{}",e);
        }
        logger.info("请求id:[" + id + "][" + servletPath+"]结束,当前时间戳：" + end + ",用时:" + String.valueOf(end - start) + "毫秒");
    }

}
