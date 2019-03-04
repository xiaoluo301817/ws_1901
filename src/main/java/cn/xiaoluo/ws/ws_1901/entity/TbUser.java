package cn.xiaoluo.ws.ws_1901.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author luowenqin
 * @create 2019-02-28 15:32
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class TbUser implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private Integer age;

    private String sex;

    private String phone;

    private String adress;

    private Date createDate;

    private Date updateDate;

    private String status;

}
