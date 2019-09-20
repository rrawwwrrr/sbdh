package ru.sbdh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.sbdh.config.Article;
import ru.sbdh.config.ArticleMapper;
import ru.sbdh.config.PersistenceConfig;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class ArticleMapperIntegrationTest {

    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void whenRecordsInDatabase_shouldReturnArticleWithGivenId() {
        Article article = articleMapper.getArticle(1L);
        System.out.println();
//        assertThat(article).isNotNull();
//        assertThat(article.getId()).isEqualTo(1L);
//        assertThat(article.getAuthor()).isEqualTo("Baeldung");
//        assertThat(article.getTitle()).isEqualTo("Working with MyBatis in Spring");
    }

}
