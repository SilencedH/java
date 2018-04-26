package cn.youzule.demo.rabitmq;

import cn.youzule.demo.rabitmq.sender.HelloSender;
import cn.youzule.demo.rabitmq.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabitmqApplicationTests {

	@Autowired
	private TopicSender topicSender;

	@Test
	public void contextLoads() {
	}


	/*测试*/
	@Test
	public void testMq(){
		//helloSender.send();
		topicSender.send1("topic-1");
		topicSender.send2("topic-2");
		topicSender.send3("topic-3");
	}
}
