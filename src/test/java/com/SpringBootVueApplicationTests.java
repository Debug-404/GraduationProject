package com;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SpringBootVueApplicationTests {


    private static final long TOKEN_EXPIRED_TIME = 7 * 24 * 60 * 60;

    @Test
    public void contextLoads() {

    }

    @Test
    public void test2() {
        System.out.println(new Date(System.currentTimeMillis()));

        System.out.println(new Date(System.currentTimeMillis() + TOKEN_EXPIRED_TIME));
    }
}
