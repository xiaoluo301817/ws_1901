package cn.xiaoluo.ws.ws_1901.service.impl;

import cn.xiaoluo.ws.ws_1901.entity.TbUser;
import cn.xiaoluo.ws.ws_1901.entity.TbUserExample;
import cn.xiaoluo.ws.ws_1901.mapper.TbUserMapper;
import cn.xiaoluo.ws.ws_1901.service.TbUserService;
import cn.xiaoluo.ws.ws_1901.vo.PageParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luowenqin
 * @create 2019-02-28 16:01
 */

@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public boolean addTbUser(TbUser user) {
        boolean flag =false;
        int insert = tbUserMapper.insert(user);
        if (insert>0)flag =true;
        return flag;
    }

    @Override
    public boolean deleteTbUser(Integer[] ids) {
        boolean flag =false;
        for (Integer id : ids) {
            int i = tbUserMapper.deleteByPrimaryKey(id);
            if (i>0)flag =true;
        }
        return flag;
    }

    @Override
    public boolean updateTbUser(TbUser tbUser) {

        boolean flag =false;
        int insert = tbUserMapper.updateByPrimaryKey(tbUser);
        if (insert>0)flag =true;
        return flag;


    }

    @Override
    public List<TbUser> findAll() {
        List<TbUser> tbUsers = tbUserMapper.selectByExample(null);
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser);
        }
        return tbUsers;
    }

    @Override
    public TbUser findOne(Integer id) {
        return tbUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean findByName(String name) {
        return false;
    }


    @Override
    public  TbUser queryLogin(String username,String password){
        TbUser user=null;
        TbUserExample userExample =new TbUserExample();
        TbUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username).andPasswordEqualTo(password).andStatusEqualTo("1");
        List<TbUser> tbUsers = tbUserMapper.selectByExample(userExample);
        user =tbUsers.size()>0? user =tbUsers.get(0):null;
        return  user;
    };


    @Override
    public PageInfo<TbUser> findPage(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize());
        List<TbUser> tbUsers = tbUserMapper.selectByExample(null);
        PageInfo pageInfo =new PageInfo(tbUsers);
        return pageInfo;
    }

    @Override
    public PageInfo<TbUser> findPage(TbUser user, PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize());
        TbUserExample  example =new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        if (user !=null){
            if (user.getUsername() !=null && !"".equals(user.getUsername())){
                criteria.andUsernameLike("%"+user.getUsername()+"%");
            }
        }
        List<TbUser> tbUsers = tbUserMapper.selectByExample(example);
        PageInfo pageInfo =new PageInfo(tbUsers);
        return pageInfo;
    }
}
