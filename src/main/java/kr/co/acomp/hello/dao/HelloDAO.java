package kr.co.acomp.hello.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDAO {
    public int addTwoNumber(int a, int b){
        return a+b;
    }
}
