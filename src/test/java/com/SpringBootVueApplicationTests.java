package com;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mapper.DormRoomMapper;
import com.mapper.StudentMapper;
import com.model.DormRoom;
import com.service.AdminService;
import com.service.NoticeService;
import com.service.StudentService;
import com.service.WorkerService;
import com.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringBootVueApplicationTests {

    @Resource
    StudentService studentService;

    @Resource
    StudentMapper studentMapper;
    @Resource
    NoticeService noticeService;

    @Resource
    AdminService adminService;

    @Resource
    WorkerService workerService;

    @Resource
    DormRoomMapper dormRoomMapper;

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
        List<DormRoom> list = dormRoomMapper.find("11");
        list.forEach(System.out::println);
    }

}
