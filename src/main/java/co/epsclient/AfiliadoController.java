package co.epsclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/afiliado")
public class AfiliadoController {
	
	@Value("${afiliados.service}")
	private String serviceUrl;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Afiliado[] getAfiliados() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(serviceUrl, Afiliado[].class);
	}

}
