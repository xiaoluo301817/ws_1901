package cn.xiaoluo.ws.ws_1901.controller;

import cn.xiaoluo.ws.ws_1901.entity.TbUser;
import cn.xiaoluo.ws.ws_1901.service.TbUserService;
import cn.xiaoluo.ws.ws_1901.vo.PageData;
import cn.xiaoluo.ws.ws_1901.vo.PageParam;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luowenqin
 * @create 2019-02-28 16:11
 */

@Controller
@RequestMapping(value = "/user")
public class TbUserController {

    @Autowired
    private TbUserService userService;




    @GetMapping(value ="/gotoIndex")
    public   String gotoIndex(){
        return  "main/index";
    }




    @GetMapping(value ="/gotoList")
    public   String gotoList(){
        return  "user/list";
    }



    /**
     * 获取当前登录名称
     * @param session
     * @return
     */
    @GetMapping(value = "/getName")
    public  @ResponseBody
    Map getName(HttpSession session){
        Map map =new HashMap();
        String username =(String)session.getAttribute("username");
        map.put("username",username);
        return  map;
    }


    /**
     * 退出当前登录
     * @param session
     * @return
     */
    @GetMapping(value = "/logout")
    public  void logout(HttpSession session , HttpServletResponse response)  throws Exception{
        session.invalidate();
        response.sendRedirect("/login.html");
    }




    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/findOne/{id}")
    public @ResponseBody TbUser findOne(@PathVariable("id") Integer id){
        return  userService.findOne(id);
    }






    /**
     *   查询所用的用户信息
     */
    @GetMapping(value = "/findUseAll")
    public @ResponseBody List findUseAll(){
        return  userService.findAll();
    }


    /**
     *
     * @return
     */
//    @GetMapping(value = "getPageDataList")
//    public  @ResponseBody PageData getPageDataList(Integer page,Integer limit,String username){
//
//
//        System.out.println(username);
//
//        PageData pageData =new PageData();
//
//        PageParam pageParam =new PageParam();
//
//        if (page !=null)pageParam.setPageNo(page);
//        if (limit !=null)pageParam.setPageSize(limit);
//        PageInfo<TbUser> pageInfo = userService.findPage(pageParam);
//        pageData.setCode(0);
//        pageData.setMsg("1");
//        pageData.setCount(pageInfo.getTotal());
//        pageData.setData(pageInfo.getList());
//
//        return  pageData;
//    }




    @GetMapping(value = "getPageDataList")
    public  @ResponseBody PageData getPageDataList(Integer page,Integer limit,String username){

        TbUser user =new TbUser();
        if (username !=null){
            user.setUsername(username);
        }

        PageData pageData =new PageData();

        PageParam pageParam =new PageParam();

        if (page !=null)pageParam.setPageNo(page);
        if (limit !=null)pageParam.setPageSize(limit);

        PageInfo<TbUser> pageInfo =null;
        pageInfo =(user.getUsername() ==null)?userService.findPage(pageParam):
                                    userService.findPage(user,pageParam);
        pageData.setCode(0);
        pageData.setMsg("1");
        pageData.setCount(pageInfo.getTotal());
        pageData.setData(pageInfo.getList());

        return  pageData;
    }
}
