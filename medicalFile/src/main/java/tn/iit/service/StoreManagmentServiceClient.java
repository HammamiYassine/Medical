package tn.iit.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import tn.iit.dto.ArticleDTO;

@Service
public class StoreManagmentServiceClient {
	private final RestTemplate restTemplate;
	
	public StoreManagmentServiceClient(RestTemplate restTemplate) {this.restTemplate = restTemplate;}
	
	public List<ArticleDTO> getAllArticlesDTO(){
		UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://localhost:8585/api/articles")
				.build().encode();	
		return restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET,new HttpEntity(null, new HttpHeaders()), new ParameterizedTypeReference<List<ArticleDTO>>() {}).getBody();		
	}
	
	public ArticleDTO getArticleById(int id) {
		UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://localhost:8585/api/articles")
				.path("/{id}")
				.build()
				.expand(id)
				.encode();
		ResponseEntity<ArticleDTO> service = restTemplate.exchange(uriComponents.toUri(),HttpMethod.GET,new HttpEntity(null, new HttpHeaders()), ArticleDTO.class);
		return service.getBody();
	}
	
	
}
