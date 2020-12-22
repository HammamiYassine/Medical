package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{
	Article findById(int id);
}
