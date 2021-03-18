package com.epsilon.training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epsilon.training.config.AppConfig1;
import com.epsilon.training.config.AppConfig2;
import com.epsilon.training.config.AppConfig3;
import com.epsilon.training.config.AppConfig4;
import com.epsilon.training.config.AppConfig5;
import com.epsilon.training.dao.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DisplayProductCount {

	public static void main(String[] args)throws Exception {

		AnnotationConfigApplicationContext ctx;

		ctx = new AnnotationConfigApplicationContext(AppConfig5.class);

		ProductDao dao = ctx.getBean("htDao", ProductDao.class);
		log.debug("Inside DisplayProductCount.main(), dao is an instanceOf {} ", dao.getClass().getName());

		long pc = dao.count();
		log.debug("There are {} products", pc);
		ctx.close();
	}
}
