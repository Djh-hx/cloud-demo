package top.daji.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import top.daji.feign.clients.folback.folbackFactory;


public class DefaultFeignConfiguration {

    /**
     * 定义feign日志级别
     * NONE, 不记录日志 (默认)。
     * BASIC, 只记录请求方法和URL以及响应状态代码和执行时间。
     * HEADERS, 记录请求和应答的头的基本信息。
     * FULL, 记录请求和响应的头信息，正文和元数据。
     * @return
     */
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }
    @Bean
    public folbackFactory fol(){
        return new folbackFactory();
    }
}