package kr.co.acomp.hello.dao;

import kr.co.acomp.hello.dao.ArticleDAO;
import kr.co.acomp.hello.vo.Article;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // Spring-test Module 사용하여 반복되는 junit 간소화
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*.xml") // 코드 안이 아니라 annotaion dmfh
public class ArticleDAOTest {

//    private ApplicationContext ctx;
//    @Before
//    public void setup(){
//        // @test annotaion 전 초기화 하는 너낌
//        ctx = new FileSystemXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/*.xml");
//
//    }
    @Autowired //Autowired 를 통한 DI
    private ArticleDAO dao;

    @Test
    @Ignore
    public void testInsertArticle(){
        Article article = dao.selectArticleById("1");
        System.out.println(article.toString());
        dao.insertArticle(article);
    }

    @Test
    public void testSelectArticleById(){
//        bean 설정 파일 지정 서블린 컨텍스트 xml

//        Dependency lookup
//        ArticleDAO dao = ctx.getBean("articleDAO",ArticleDAO.class);

//        Article article = dao.selectArticleById("");
//
////        같고 온 값이 lee 가 True 면 통과
        Article article = dao.selectArticleById("1");
        System.out.println(article);
        Assert.assertTrue(article.getAuthor().equals("TEST"));
    }
}
