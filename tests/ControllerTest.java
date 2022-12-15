import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.Swagger2SpringBoot;
import io.swagger.api.*;
import io.swagger.model.User;
import io.swagger.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Swagger2SpringBoot.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository repository;

    @MockBean
    private GetusersApiController getusersApiController;

    @MockBean
    private GetusersByIdApiController getusersByIdApiController;

    @MockBean
    private CreateUsersApiController createUsersApiController;

    @MockBean
    private UpdateUsersByIdApiController updateUsersByIdApiController;

    @MockBean
    private DeleteUsersByIdApiController deleteUsersByIdApiController;


    @Test
    public void givenUsers_thenStatus200()
            throws Exception {

        getusersApiController.getusersGet();

        mvc.perform(get("/users/getusers")
                        .header("Accept", MediaType.APPLICATION_JSON)
                        .header("Content-Type", MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void givenUsersById_thenStatus200()
            throws Exception {

        getusersByIdApiController.getusersByIdUserIdGet(1);

        mvc.perform(get("/users/getusersById/1")
                        .header("Accept", MediaType.APPLICATION_JSON)
                        .header("Content-Type", MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void CreateUser_thenStatusOK()
            throws Exception {

        User user = new User();
        ObjectMapper objetMapper = new ObjectMapper();
        String content = objetMapper.writeValueAsString(user);
        createUsersApiController.createUsersPost(user);

        mvc.perform(post("/users/createUsers")
                        .content(content)
                        .header("Accept", MediaType.APPLICATION_JSON)
                        .header("Content-Type", MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void UpdateUser_thenStatusOK()
            throws Exception {

        User user = new User();
        ObjectMapper objetMapper = new ObjectMapper();
        String content = objetMapper.writeValueAsString(user);

        updateUsersByIdApiController.updateUsersByIdUserIdPut(1, new User());

        mvc.perform(put("/users/updateUsersById/1")
                        .content(content)
                        .header("Accept", MediaType.APPLICATION_JSON)
                        .header("Content-Type", MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void DeleteUsers_thenStatus200()
            throws Exception {

        deleteUsersByIdApiController.deleteUsersByIdUserIdDelete(1);

        mvc.perform(delete("/users/deleteUsersById/1")
                        .header("Accept", MediaType.APPLICATION_JSON)
                        .header("Content-Type", MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}