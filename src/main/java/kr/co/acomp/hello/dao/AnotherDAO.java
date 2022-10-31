package kr.co.acomp.hello.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AnotherDAO {
    public int square(int a){
        return a*a;
    }
}
