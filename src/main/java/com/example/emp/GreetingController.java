package com.example.emp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.emp.model.Product;


@Controller
public class GreetingController {

	@GetMapping("/product")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);

		List<Product> productlist = new ArrayList<>();
		Product product1 = new Product(1, "Dell laptop", "$1000");
		Product product2 = new Product(2, "Lenevo laptop", "$750");
		Product product3 = new Product(3, "HP laptop", "$500");
		Product product4 = new Product(4, "laptop", "$100a0");
		Product product5 = new Product(5, "Lenop laptop", "$700");
		Product product6 = new Product(6, "HP laptop", "$500");
		

		// Add Image:
		product1.setImageUrl("https://i.ibb.co/xzLsJRb/laptop.jpg");

		product2.setImageUrl("https://i.ibb.co/wW79bFP/laptop2.jpg");
		product3.setImageUrl("https://i.ibb.co/xzLsJRb/laptop.jpg");
		product4.setImageUrl("https://i.ibb.co/xzLsJRb/laptop.jpg");

		product5.setImageUrl("https://i.ibb.co/wW79bFP/laptop2.jpg");
		product6.setImageUrl("https://i.ibb.co/xzLsJRb/laptop.jpg");
		
		productlist.add(product1);
		productlist.add(product2);
		productlist.add(product3);
		productlist.add(product4);
		productlist.add(product5);
		productlist.add(product6);

		model.addAttribute("products", productlist);
		return "product";
	}
	
	@PostMapping("/product")
	public String greetingPost(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);

		List<Product> productlist = new ArrayList<>();
		Product product1 = new Product(1, "Dell laptop", "$1000");
		Product product2 = new Product(2, "Lenevo laptop", "$750");
		Product product3 = new Product(3, "HP laptop", "$500");
		Product product4 = new Product(4, "laptop", "$100a0");
		Product product5 = new Product(5, "Lenop laptop", "$700");
		Product product6 = new Product(6, "HP laptop", "$500");
		

		// Add Image:
		product1.setImageUrl("https://i.ibb.co/xzLsJRb/laptop.jpg");

		product2.setImageUrl("https://i.ibb.co/wW79bFP/laptop2.jpg");
		product3.setImageUrl("https://i.ibb.co/xzLsJRb/laptop.jpg");
		product4.setImageUrl("https://i.ibb.co/xzLsJRb/laptop.jpg");

		product5.setImageUrl("https://i.ibb.co/wW79bFP/laptop2.jpg");
		product6.setImageUrl("https://i.ibb.co/xzLsJRb/laptop.jpg");
		
		productlist.add(product1);
		productlist.add(product2);
		productlist.add(product3);
		productlist.add(product4);
		productlist.add(product5);
		productlist.add(product6);

		model.addAttribute("products", productlist);
		return "product";
	}

}