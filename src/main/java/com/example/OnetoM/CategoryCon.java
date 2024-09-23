package com.example.OnetoM;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class CategoryCon {
	@Autowired
	CategoryRes cr;
	
	@PostMapping ("/{id}")
	public Category save(@RequestBody Category c) {
		return cr.save(c);
	}
	
	@GetMapping
	public List<Category>getAll(){
		return cr.findAll();
	}
	
	@PutMapping("/{id}")
	public Category update(@PathVariable int id, @RequestBody Category c) {
		Category ca = cr.findById(id).orElseThrow();
		ca.setId(c.getId());
		ca.setName(c.getName());
		return cr.save(ca);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		cr.deleteById(id);
	}
}
