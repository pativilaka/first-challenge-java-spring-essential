package com.vilaka.firstchallenge;

import com.vilaka.firstchallenge.entities.Order;
import com.vilaka.firstchallenge.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.invoke.LambdaConversionException;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class FirstChallengeApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(FirstChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.print("Digite o código do pedido: ");
		Integer code = sc.nextInt();
		System.out.print("Digite o valor base do pedido: ");
		double basic = sc.nextDouble();
		System.out.print("Digite a porcentagem de desconto do pedido: ");
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		double valorTotal = orderService.total(order);

		System.out.println();
		System.out.println(order);
		System.out.printf("Valor total: R$ %.2f", valorTotal);

		sc.close();
	}
}
