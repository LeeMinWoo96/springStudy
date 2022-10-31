package kr.co.acomp.hello.dao;

import kr.co.acomp.hello.vo.Article;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //저장객체
public class ArticleDAO {
//    public void insertArticle(){
//        System.out.println("aa");
//    }

//    sqlSession ==> datasource xml
    @Autowired
    SqlSession sqlSession;
    public void insertArticle(Article article){
        sqlSession.insert("mappers.article-mapper.insertArticle",article);
        System.out.println(article);
    }
    public Article selectArticleById(String articleId){
//        Article article = new Article(10, "lee", "Test", "테스트 입니다.");
//        Article[] articles = sqlSession.selectList("mappers.article-mapper.selectArticleById",articleId);
        List<Article> articles = sqlSession.selectList("mappers.article-mapper.selectArticleById",articleId);
        return articles.get(0);
//        return article;
    }
}
