package com;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mapper.StudentMapper;
import com.model.Student;
import com.service.RepairService;
import com.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class SpringBootVueApplicationTests {

    @Resource
    StudentMapper studentMapper;

    @Resource
    RepairService repairService;

    @Test
    public void contextLoads() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "digua");
        String token = JwtUtils.createToken(map);
        DecodedJWT decodedJWT = JwtUtils.verifyToken(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("name"));
    }

    @Test
    public void test1() {
        List<Student> list = studentMapper.findAll();
        List<Student> collect = list.stream().filter(student -> student.getAge() > 22).collect(Collectors.toList());
        System.out.println(collect);
    }

}
