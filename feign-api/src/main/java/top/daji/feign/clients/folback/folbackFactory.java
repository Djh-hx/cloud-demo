package top.daji.feign.clients.folback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import top.daji.feign.clients.UserClient;
import top.daji.feign.pojo.User;

/**
 * @version 1.0
 * @autor DJH
 * 2022/1/24 19:51
 */
@Slf4j
public class folbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User findById(Long id) {
                log.error("查询异常",throwable);
                return new User();
            }
        };
    }
}
