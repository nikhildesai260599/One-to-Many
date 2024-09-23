package com.example.OnetoM;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProductCon {
	@Autowired
	ProductRes pr;
	
	@PostMapping("/{id}")
	public Product save(@RequestBody Product p) {
		return pr.save(p);
	}
	
	@GetMapping
	public List<Product>getAll(){
		return pr.findAll();
	}
	
	@PutMapping("/{id}")
	public Product update(@PathVariable int id, @RequestBody Product p) {
		Product pa = pr.findById(id).orElseThrow();
		pa.setId(p.getId());
		pa.setName(p.getName());
		return pr.save(pa);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		pr.deleteById(id);
	}
}
