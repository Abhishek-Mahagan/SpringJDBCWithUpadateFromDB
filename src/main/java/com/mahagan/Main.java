package com.mahagan;

import com.mahagan.dao.ProjectDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application-properties.xml");
        ProjectDao projectDao=applicationContext.getBean("projectDao", ProjectDao.class);
        int IntroCount=projectDao.UpdateProjects(1,"Updated Record");
        System.out.println("record updated"+IntroCount);

    }
}