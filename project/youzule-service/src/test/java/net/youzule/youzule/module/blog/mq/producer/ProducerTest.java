package net.youzule.youzule.module.blog.mq.producer;

import com.alibaba.fastjson.JSON;
import net.youzule.youzule.common.other.MessageEntity;
import net.youzule.youzule.module.blog.entity.Menu;
import net.youzule.youzule.utils.bean.BeanUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private MockMvc mockMvc;
    private MockHttpSession session;

    @Autowired
    private WebApplicationContext context;

    @Test
    public void test() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        session = new MockHttpSession();

        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/menus")
                    .session(session)).andExpect(MockMvcResultMatchers.status()
                    .isOk())
                    .andReturn();
            System.out.println(JSON.toJSONString(result.getResponse().getContentAsString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test1(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        session = new MockHttpSession();
        try {
            String s = mockMvc.perform(MockMvcRequestBuilders.get("/test/mq/request")
            .accept(MediaType.APPLICATION_JSON)
            .session(session)
            .characterEncoding("utf-8"))
            .andExpect(MockMvcResultMatchers.status().isOk()
            ).andReturn().getResponse().getContentAsString();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        Menu menu = new Menu();
        menu.setCreateUser("sean");
        menu.setName("zdh");
        menu.setCode(1);
        menu.setCreateTime("2018-06-12");
        MessageEntity<Menu> messageEntity = new MessageEntity<>(menu);

        byte[] bytes = BeanUtil.objectToByteArray(messageEntity);
        Message message = MessageBuilder.withBody(bytes).build();
        amqpTemplate.convertAndSend("test",message);

    }
}