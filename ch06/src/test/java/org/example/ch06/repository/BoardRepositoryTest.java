package org.example.ch06.repository;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.example.ch06.entity.board.Article;
import org.example.ch06.entity.board.Comment;
import org.example.ch06.entity.board.File;
import org.example.ch06.entity.board.User;
import org.example.ch06.repository.board.ArticleRepository;
import org.example.ch06.repository.board.CommentRepository;
import org.example.ch06.repository.board.FileRepository;
import org.example.ch06.repository.board.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@Log4j2
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("사용자 추가")
    public void test1() {

        User user = User.builder()
            .userid("a103")
            .name("김춘추")
            .birth("1992-03-11")
            .build();

        // JPA save()는 해당 엔티티를 INSERT
        User savedUser = userRepository.save(user);

        log.info(savedUser);
    }

    @Test
    @DisplayName("글 등록")
    public void test2() {
        User user = User.builder()
            .userid("a103")
            .build();

        Article article = Article.builder()
            .title("제목입니다.")
            .content("내용2 입니다.")
            .user(user)
            .build();

        Article savedArticle = articleRepository.save(article);

        log.info(savedArticle);
    }

    @Test
    @DisplayName("댓글 등록")
    public void test3() {
        User user = User.builder()
            .userid("a103")
            .build();

        Article article = Article.builder()
            .ano(3)
            .build();

        Comment comment = Comment.builder()
            .content("댓글4")
            .article(article)
            .user(user)
            .build();

        Comment savedComment = commentRepository.save(comment);
        log.info(savedComment);
    }

    @Test
    @DisplayName("파일 등록")
    public void test4() {
        Article article = Article.builder()
            .ano(3)
            .build();

        File file = File.builder()
            .ofname("이미지.jpg")
            .sfname("adsfaafasaf143411dafa1213.jpg")
            .article(article)
            .build();

        File savedFile = fileRepository.save(file);
        log.info(savedFile);
    }

    @Test
    @Transactional
    @DisplayName("글 조회")
    public void test5() {
        List<Article> articleList = articleRepository.findAll();

        for (Article article : articleList) {
            log.info(article);

            article.getCommentList().forEach(log::info);
        }
    }

    @Test
    @DisplayName("특정 글 조회")
    @Transactional
    public void test6() {
        Optional<Article> optArticle = articleRepository.findById(3);

        if(optArticle.isPresent()) {
            Article article = optArticle.get();
            log.info(article);

            article.getCommentList().forEach(log::info);
        }
    }

    @Test
    @DisplayName("파일 조회")
    public void test7() {
        List<File> fileList = fileRepository.findAll();
        fileList.forEach(log::info);
    }

    @Test
    @DisplayName("")
    public void test8() {}
    @Test
    @DisplayName("")
    public void test9() {}
}
