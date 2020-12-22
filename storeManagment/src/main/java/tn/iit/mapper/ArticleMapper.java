package tn.iit.mapper;


import java.util.List;
import java.util.stream.Collectors;

import tn.iit.dto.ArticleDTO;
import tn.iit.entity.Article;

public class ArticleMapper {
	public static Article DtoToEntity(ArticleDTO art) {
		Article article = new Article();
		article.setId(art.getId());
		article.setDescription(art.getDescription());
        return article ;
	}
	
	   public static ArticleDTO EntityToDto(Article art) {
		   ArticleDTO articleDto = new ArticleDTO();
		   articleDto.setId(art.getId());
		   articleDto.setDescription(art.getDescription());
           return articleDto;                            
       }
	   
	   public static List<ArticleDTO> EntityToDtos(List<Article> arts) {
		   return arts.stream().map(x-> EntityToDto(x)).collect(Collectors.toList());                            
       }
	   
}
