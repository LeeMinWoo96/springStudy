package kr.co.acomp.hello;

import kr.co.acomp.hello.service.BbsService;
import kr.co.acomp.hello.service.HelloService;
import kr.co.acomp.hello.vo.Article;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
//    private HelloService service2;
//
//    public HelloMain(HelloService helloService){
//        this.service2 = helloService;
//    }
    public static void main(String args[]){

        // 설정파일은 클래스 패스 루트에 존재
        // 스프링 컨테이너을 설정파일을 읽어서 생성
        // 해당 설정파일에 정의된 빈들 생성
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-context.xml");

        // bean lookup
        // 여기서 빈 객체가 생성되는게 아니라 위에서 빈 객체 생성하고 여기서 룩업을 함
        // 즉 매번 생성하는게 아니라 기존에 있는 객체를 재사용하는게 아니라 가벼움
        // 아래 괄호가 나가는 순간 dao 변수는 사라지지만 객체는 사라지지 않고 컨테이너에 반환됨 즉 가비지 컬렉터가 매번 가동되지 않아
        // 성능상 되게 가벼워짐
        // DL
        HelloService service = ctx.getBean("helloService", HelloService.class);
        int result = service.calcTwoNumbersAndSquare(4,3);
        System.out.print(result);

//        System.out.print();
//        HelloDAO dao = new HelloDAO();
//        int result = dao.addTwoNumber(3,6);
//        System.out.print(result);

        BbsService bbsService = ctx.getBean("bbsService", BbsService.class);
        bbsService.registArticle(new Article());;
//        System.out.printf("",result);

    }
}
