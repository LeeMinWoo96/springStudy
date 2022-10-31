package kr.co.acomp.hello.service;

import kr.co.acomp.hello.dao.ArticleDAO;
import kr.co.acomp.hello.exception.BizException;
import kr.co.acomp.hello.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsService {
    @Autowired // setter, 생성자했던 DI 말고 어노테이션 하나 딱 붙이면 댐
    private ArticleDAO articleDao;
//
    public void setArticleDao(ArticleDAO articleDao){
        this.articleDao = articleDao;
    }
    public void registArticle(Article article){
        articleDao.insertArticle(article);

    }
    public Article viewArticleDetail(String articleId){
        return articleDao.selectArticleById(articleId);
    }

    public void testService(){
        System.out.println("target invoked..");
        throw new BizException("testService Fail..");
    }
}
