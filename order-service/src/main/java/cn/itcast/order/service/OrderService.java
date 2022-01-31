package cn.itcast.order.service;

import cn.itcast.order.clients.UserClient;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserClient userClient;


    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        User user = userClient.findById(order.getUserId());
        order.setUser(user);
        // 4.返回
        return order;
    }
    //    @Autowired
//    private RestTemplate restTemplate;
//
//
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
////        String url="http://localhost:8081/user/"+order.getUserId();
//        String url="http://userservice/user/"+order.getUserId();
//        //服务远程调用    基于restTemplate发送的http请求
//        User user = restTemplate.getForObject(url, User.class);
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }
}
