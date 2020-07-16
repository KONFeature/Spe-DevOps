package com.supinfo.devops.cicddemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CiCdDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void simpleMath1() {
        assertThat(1 + 1).isEqualTo(2);
        assertThat(2 + 2).isEqualTo(4);
        assertThat(3 + 3).isEqualTo(6);
    }

    @Test
    void simpleMath2() {
        assertThat(1 * 1).isEqualTo(1);
        assertThat(2 * 2).isEqualTo(4);
        assertThat(3 * 3).isEqualTo(9);
    }

}
