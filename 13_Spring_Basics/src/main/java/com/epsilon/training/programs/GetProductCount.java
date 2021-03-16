package com.epsilon.training.programs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epsilon.training.dao.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetProductCount { 

	public static void main(String[] args) {
		ApplicationContext ctx;
		
		ctx = new ClassPathXmlApplicationContext("context.xml");
		
		ProductDao dao = ctx.getBean("jdbc", ProductDao.class);
		long pc = dao.count();		
		log.debug("There are {} products", pc);
		
		dao = ctx.getBean("dummy", ProductDao.class);
		pc = dao.count();		
		log.debug("There are {} products", pc);
		
		ProductDao dao1 = ctx.getBean("dummy", ProductDao.class);
		pc = dao1.count();		
		log.debug("There are {} products", pc);
		log.debug("The dao == dao1 is {}", dao == dao1);
		
		dao1 = ctx.getBean("dao1", ProductDao.class);
		pc = dao1.count();		
		log.debug("There are {} products", pc);
		
		dao1 = ctx.getBean("dao2", ProductDao.class);
		pc = dao1.count();		
		log.debug("There are {} products", pc);
		
		((AbstractApplicationContext) ctx).close();

	}

}
