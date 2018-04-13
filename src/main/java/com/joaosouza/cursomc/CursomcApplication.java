package com.joaosouza.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaosouza.cursomc.domain.Categoria;
import com.joaosouza.cursomc.domain.Cidade;
import com.joaosouza.cursomc.domain.Estado;
import com.joaosouza.cursomc.domain.Produto;
import com.joaosouza.cursomc.repositories.CategoriaRepository;
import com.joaosouza.cursomc.repositories.CidadeRepository;
import com.joaosouza.cursomc.repositories.EstadoRepository;
import com.joaosouza.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Rio Grande do Sul");
		Estado est2 = new Estado(null, "Santa Catarina");
		Estado est3 = new Estado(null, "Paraná");
		Estado est4 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Porto Alegre", est1);
		Cidade c2 = new Cidade(null, "Florianópolis", est2);
		Cidade c3 = new Cidade(null, "Curitiba", est3);
		Cidade c4 = new Cidade(null, "São Paulo", est4);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2));
		est3.getCidades().addAll(Arrays.asList(c3));
		est4.getCidades().addAll(Arrays.asList(c4));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		
		
	}
}
