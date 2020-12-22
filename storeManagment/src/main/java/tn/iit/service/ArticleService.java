package tn.iit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.dao.ArticleRepository;
import tn.iit.dto.ArticleDTO;
import tn.iit.entity.Article;
import tn.iit.mapper.ArticleMapper;

@Service
public class ArticleService implements Iarticle {
    @Autowired
    private ArticleRepository articleRepository;
    
    @Override
    public List<ArticleDTO> getAllArticles() {
        return ArticleMapper.EntityToDtos(articleRepository.findAll());
    }
    
    @Override
    public ArticleDTO findById(int id) {
    	Article art = articleRepository.findById(id);
    	ArticleDTO resultDTO = ArticleMapper.EntityToDto(art);
        return resultDTO;
        }
    
    @Override
    public ArticleDTO save(ArticleDTO artdto) {
        Article art = ArticleMapper.DtoToEntity(artdto);
        art =  articleRepository.save(art);
        ArticleDTO resultDTO = ArticleMapper.EntityToDto(art);
        return resultDTO;
    }
    
    @Override
    public void delete(int id) {
        articleRepository.deleteById(id);
    }
    
	@Override
	public ArticleDTO update(ArticleDTO artdto) {
		Article art = ArticleMapper.DtoToEntity(artdto);
        art =  articleRepository.save(art);
        ArticleDTO resultDTO = ArticleMapper.EntityToDto(art);
        return resultDTO;
	}
}