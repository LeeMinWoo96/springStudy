package kr.co.acomp.hello.service;

import kr.co.acomp.hello.dao.AnotherDAO;
import kr.co.acomp.hello.dao.HelloDAO;

//"""
//즉 스프링 컨테이너에 생성된 객체를 injection 하며 수행하기 때문에
//매번 객체를 생성하지 않아도 되서 효율적
//"""

public class HelloService {
    private HelloDAO dao;
    private AnotherDAO anotherDAO;

    // 생성자 injection
    public HelloService(HelloDAO helloDAO){
        this.dao = helloDAO;
    }

//    // 자동으로 DI 될 수 있도록 설정 파일에서 설정해줄 수 있음 Setter injection
//    public void setDao(HelloDAO dao){
//        this.dao = dao;
//    }

    public void setAnotherDAO(AnotherDAO dao){
        this.anotherDAO = dao;
    }
    public int calcTwoNumbersAndSquare(int a, int b){
        //하위 방식으로 진행한다면 메소드 호출 시 객체가 생성되니 비 효율적
        // dao = new HelloDAO();
        //injection 으로 객체 생성을 따로 하지 않아도 수행 (효율성)
        // return dao.addTwoNumber(a,b);


        int result = dao.addTwoNumber(a,b);
        return anotherDAO.square(result);
    }
}
