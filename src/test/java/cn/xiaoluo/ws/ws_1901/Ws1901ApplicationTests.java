package cn.xiaoluo.ws.ws_1901;

import cn.xiaoluo.ws.ws_1901.entity.TbUser;
import cn.xiaoluo.ws.ws_1901.service.TbUserService;
import cn.xiaoluo.ws.ws_1901.vo.PageParam;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Ws1901ApplicationTests {


    @Autowired
    private TbUserService userService;


    @Test
    public void contextLoads() {

        TbUser user =new TbUser();
        PageParam pageParam =new PageParam();
        pageParam.setPageNo(1);
        pageParam.setPageSize(10);
        PageInfo<TbUser> page = userService.findPage(pageParam);
        System.out.println(page);


    }

}
