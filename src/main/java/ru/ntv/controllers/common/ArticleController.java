package ru.ntv.controllers.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ntv.dto.request.common.GetByArticleHeaderRequest;
import ru.ntv.dto.request.common.GetByArticleIdRequest;
import ru.ntv.dto.request.common.GetByArticleThemesRequest;
import ru.ntv.dto.response.common.ArticleListResponse;
import ru.ntv.dto.response.common.ArticleResponse;
import ru.ntv.entity.Article;
import ru.ntv.service.ArticleService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("common/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("byArticleHeader")
    ResponseEntity<ArticleResponse> articleByArticleHeader(@RequestBody GetByArticleHeaderRequest req){
      Optional<Article> optionalArticle = articleService.findByHeader(req.getHeader());

      return ResponseEntity.ok(new ArticleResponse(optionalArticle.get()));
    }

    @GetMapping("byArticleThemes")
    ResponseEntity<ArticleListResponse> articlesByArticleThemes(@RequestBody GetByArticleThemesRequest req){
        List<Article> optionalArticleList = articleService.getArticlesByThemes(req.getThemes());
        return ResponseEntity.ok(new ArticleListResponse(optionalArticleList));
    }

    @GetMapping("byId")
    ResponseEntity<ArticleResponse> articleByArticleId(@RequestBody GetByArticleIdRequest req){
        Optional<Article> optionalArticle = articleService.findById(req.getId());

        return ResponseEntity.ok(new ArticleResponse(optionalArticle.get()));
    }
}