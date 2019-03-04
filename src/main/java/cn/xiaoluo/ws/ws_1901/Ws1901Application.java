package cn.xiaoluo.ws.ws_1901;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "cn.xiaoluo.ws.ws_1901.mapper")
public class Ws1901Application {

    public static void main(String[] args) {
        SpringApplication.run(Ws1901Application.class, args);
    }

}
