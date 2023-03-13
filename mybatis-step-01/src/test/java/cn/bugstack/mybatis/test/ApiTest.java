package cn.bugstack.mybatis.test;

import cn.bugstack.mybatis.Resources;
import cn.bugstack.mybatis.SqlSession;
import cn.bugstack.mybatis.SqlSessionFactory;
import cn.bugstack.mybatis.SqlSessionFactoryBuilder;
import cn.bugstack.mybatis.test.po.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.Reader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class ApiTest {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(#\\{(.*?)})");
        String sql = "SELECT id, userId, userName, userHead, createTime\n" +
                "        FROM user\n" +
                "        where id = #{id,JDBCTYPE=BIGINGEGER} and name = #{name,JDBCTYPE=NVACHAR2}";
        Matcher matcher = pattern.matcher(sql);
        for (int i = 1; matcher.find(); i++) {
            String g1 = matcher.group(1);// #{id} ,第一个（）里面的内容
            String g2 = matcher.group(2);//id 属性  第二个（）里面的内容
            sql = sql.replace(g1, "?");
            System.out.println(g1);
            System.out.println(g2);
        }
        System.out.println(sql);
    }

    @Test
    public void test_queryUserInfoById() {
        String resource = "mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                User user = session.selectOne("cn.bugstack.mybatis.test.dao.IUserDao.queryUserInfoById", 1L);
                System.out.println(JSON.toJSONString(user));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test_queryUserList() {
        String resource = "mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                User req = new User();
                req.setUserId("10001");
                List<User> userList = session.selectList("cn.bugstack.mybatis.test.dao.IUserDao.queryUserList", req);
                System.out.println(JSON.toJSONString(userList));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
