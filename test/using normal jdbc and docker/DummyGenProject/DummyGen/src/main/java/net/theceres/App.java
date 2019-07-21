package net.theceres;

import net.theceres.model.service.UserService;
import net.theceres.model.vo.UserVo;
import net.theceres.util.IdGenerator;
import net.theceres.util.NameGenerator;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AbstractApplicationContext factory = new GenericXmlApplicationContext("application-context.xml");

        UserService userService = (UserService) factory.getBean("UserService");
        UserVo userVo = (UserVo) factory.getBean("UserVo");
        userVo.setId(IdGenerator.run());
        userVo.setName(NameGenerator.run());
        userVo.setAge((int) (Math.random() * 100));
        userService.createUser(userVo);

        for (UserVo vo : userService.selectAllUser()) {
            System.out.println(vo);
        }

    }
}
