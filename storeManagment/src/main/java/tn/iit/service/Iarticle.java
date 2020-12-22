package tn.iit.service;

import java.util.List;

import tn.iit.dto.ArticleDTO;

public interface Iarticle {
	List<ArticleDTO> getAllArticles();
	ArticleDTO findById(int id);
    ArticleDTO save(ArticleDTO art);
    ArticleDTO update(ArticleDTO art);
    void delete(int id);
}
