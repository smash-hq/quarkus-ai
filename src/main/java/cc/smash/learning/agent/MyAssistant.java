package cc.smash.learning.agent;

import dev.langchain4j.service.SystemMessage;
import io.quarkiverse.langchain4j.RegisterAiService;


@RegisterAiService // 👈 告诉 Quarkus 这是一个 AI 服务
public interface MyAssistant {
    @SystemMessage("你是一个精通微服务架构的资深后端专家，请用简练的语言回答。")
    String chat(String userMessage); // 👈 核心调用方法
}
