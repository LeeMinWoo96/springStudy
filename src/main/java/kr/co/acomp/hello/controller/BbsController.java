package kr.co.acomp.hello.controller;

import kr.co.acomp.hello.service.BbsService;
import kr.co.acomp.hello.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bbs")
public class BbsController {
    @Autowired
    private BbsService bbsService;

    @GetMapping("/")
    public String index(){
//        bbsService.testService();
        bbsService.registArticle(new Article(5,"kim","test","test"));
        return "index";
    }
//    객체를 response 하면 json 형식으로 반환됨
    @GetMapping("/{articleId}")
    @ResponseBody
    public Article viewDetail(@PathVariable String articleId){
        Article article = bbsService.viewArticleDetail(articleId);
        return article;
    }

    @PostMapping("/write")
    @ResponseBody
    public Article write(@RequestBody Article article){
//        Article article1 = article;
        bbsService.registArticle(article);
        return article;
    }


//    @GetMapping("/{articleId}")
//    public String viewDetail(@PathVariable String articleId){
//        System.out.println("글 번호는 : "+ articleId);
//        return "write_ok";
//    }

//    @PostMapping("/write")
//    public ModelAndView dowrite(Article article){
//        bbsService.registArticle(article);
////        web-inf/views/write_ok.jsp 호출 해당 정보는 servlet-context.xml 에 명시
////        web.xml 에 servlet-context.xml 쓴다고 함
////        write_ok.jsp 파일로 이동함
//        System.out.println("post request ...");
////        return "write_ok";
////        write_ok.jsp 파일로 article 객체 전달
//        return new ModelAndView("write_ok").addObject("article",article);
//    }
//    @GetMapping("/write")
//    public String write(@RequestParam("author") String author){
//        bbsService.registArticle(new Article());
////        web-inf/views/write_ok.jsp 호출 해당 정보는 servlet-context.xml 에 명시
////        web.xml 에 servlet-context.xml 쓴다고 함
////        write_ok.jsp 파일로 이동함
////        만약 jsp 페이지로 이동이 아니라 json 등 객체 값을 리턴하고 싶으면 @ResponseBody fmf aovld
//        System.out.println("get request ...");
//        System.out.print(author);
//        return "write_ok";
//    }
}
