package cc.smash.learning.resource;

import cc.smash.learning.agent.MyAssistant;
import cc.smash.learning.agent.TravelAgent;
import cc.smash.learning.dto.TravelDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/ai")
public class AssistantResource {
    private static final Logger log = LoggerFactory.getLogger(AssistantResource.class);
    @Inject
    MyAssistant assistant;
    @Inject
    TravelAgent travelAgent;
    @Inject
    ObjectMapper mapper;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String askAI(@QueryParam("q") String question) {
        if (question == null || question.isEmpty()) {
            return "请提供问题，例如: /ai?q=什么是Quarkus";
        }
        // ? 直接调用接口方法，大模型的结果会自动返回
        String chat = assistant.chat(question);
        return chat;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/travel")
    public TravelDTO travel(String userRequestText) {
        if (userRequestText == null || userRequestText.isEmpty()) {
            return new TravelDTO();
        }
        log.info("用户输入：{}", userRequestText);
        String aiReply = travelAgent.chat(userRequestText);
        log.info("AI 输出：{}", aiReply);
        TravelDTO plan = travelAgent.extract(aiReply);

        try {
            String json = mapper.writeValueAsString(plan);
            log.info("AI 输出：{}", json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return plan;
    }
}
