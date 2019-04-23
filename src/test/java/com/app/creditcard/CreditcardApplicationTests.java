package com.app.creditcard;

import com.app.creditcard.controller.AppController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class CreditcardApplicationTests {

    private MockMvc mockMvc;

    @InjectMocks
    private AppController appController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(appController)
                .setViewResolvers(viewResolver())
                .build();
    }

    private ViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("classpath:templates/");
        viewResolver.setSuffix(".html");

        return viewResolver;
    }

    @Test
    public void welcomePage() throws Exception {

        mockMvc.perform(get("/app/welcome"))
                .andExpect(status().isOk());

    }

    @Test
    public void registerPage() throws Exception {

        mockMvc.perform(get("/app/register"))
                .andExpect(status().isOk());

    }

    @Test
    public void errorPage() throws Exception {

        mockMvc.perform(get("/error"))
                .andExpect(status().isOk())
                .andExpect(model().size(1));

    }

}
